package com.williansmartins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import com.williansmartins.vo.UserVO;

public class DAOJDBC {

    private final static String GET_COMPETIDORES = "SELECT u.nome nome, u.cpf cpf, count(r.acertou) acertos, u.email email, u.telefone telefone, u.aluno"
    		+ " aluno " +  
												" FROM quiz.user u  " + 
												" LEFT JOIN quiz.resposta r " + 
												" on acertou='sim' " + 
												" and u.id = r.user_id " + 
												" group by user_id " + 
												" order by Acertos desc;";

    private final static String GET_COMPETIDORES_2 = 
    		" select a.nome, a.cpf, a.acertos, b.erros, (a.acertos - b.erros) saldo , a.email, a.telefone, a.aluno from " +
    		" (SELECT u.nome nome, u.cpf cpf,count(r.acertou) acertos, u.email email, u.telefone telefone, u.aluno " +
    		" FROM quiz.user u " +
    		" LEFT JOIN quiz.resposta r " +
    		" on acertou='sim' " +
    		" and u.id = r.user_id " +
    		" group by user_id) a, " +

    		" (SELECT u.nome nome, u.cpf cpf,count(r.acertou) erros, u.email email, u.telefone telefone, u.aluno " +
    		" FROM quiz.user u " +
    		" LEFT JOIN quiz.resposta r " +
    		" on acertou='não' " +
    		" and u.id = r.user_id " +
    		" group by user_id) b " +
    		" where a.nome = b.nome " +
    		" and a.cpf = b.cpf " + 
    		" order by (a.acertos - b.erros) desc";

	public List<UserVO> buscarCompetidores() throws PersistenceException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
                conn = ConnectionManager.getConnection();
                stmt = createStatementWithLog(conn, GET_COMPETIDORES_2);
                rs = stmt.executeQuery();
                
                return toVO(rs);
        } catch (SQLException e) {
                String errorMsg = "Erro ao consultar!";
                throw new PersistenceException(errorMsg, e);
        } finally {
                ConnectionManager.closeAll(conn, stmt, rs);
        }
}
	
	private List<UserVO> toVO(ResultSet rs) throws SQLException {
		List<UserVO> lista = new ArrayList<UserVO>();
		while (rs.next()) {
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String email = rs.getString("email");
			String telefone = rs.getString("telefone");
			boolean aluno = rs.getBoolean( "aluno" );
			int acertos = rs.getInt("acertos");
			int erros = rs.getInt("erros");
			int saldo = rs.getInt("saldo");

			lista.add(new UserVO(nome, cpf, null, email, telefone, aluno, acertos, erros, saldo));
		}
		return lista;
	}

	private static PreparedStatement createStatementWithLog(Connection conn,
			String sql) throws SQLException {
		if (conn == null)
			return null;

		System.out.print("SQL: " + sql);
		return conn.prepareStatement(sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
	}
}
