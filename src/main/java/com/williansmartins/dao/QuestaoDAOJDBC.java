package com.williansmartins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import com.williansmartins.vo.QuestaoVO;

public class QuestaoDAOJDBC {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

	public List<QuestaoVO> buscarPorTema(String assunto) throws PersistenceException {
        
        try {
                conn = ConnectionManager.getConnection();
                stmt = createStatementWithLog(conn, "SELECT * from questao where tema = '" + assunto + "'");
                rs = stmt.executeQuery();
                
                return toVO(rs);
        } catch (SQLException e) {
                String errorMsg = "Erro ao consultar!" + e.getMessage();
                throw new PersistenceException(errorMsg, e);
        } finally {
                ConnectionManager.closeAll(conn, stmt, rs);
        }
}
	
	private List<QuestaoVO> toVO(ResultSet rs) throws SQLException {
		List<QuestaoVO> lista = new ArrayList<QuestaoVO>();
		
		while (rs.next()) {
			QuestaoVO q = new QuestaoVO();
			q.setCorreta( rs.getString("correta").charAt(0) );
			q.setId( rs.getInt("id") );
			q.setPergunta( rs.getString("pergunta") );
			q.setRespostaA( rs.getString("respostaA") );
			q.setRespostaB( rs.getString("respostaB") );
			q.setRespostaC( rs.getString("respostaC") );
			q.setRespostaD( rs.getString("respostaD") );
			q.setRespostaE( rs.getString("respostaE") );
			
			lista.add( q );
		}
		return lista;
	}

	private static PreparedStatement createStatementWithLog(Connection conn, String sql) throws SQLException {
		if (conn == null){
			return null;
		}

		System.out.print("SQL: " + sql);
		return conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	}
}
