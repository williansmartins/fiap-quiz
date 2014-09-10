// Include gulp
var gulp = require('gulp'); 

var sass = require('gulp-sass');
var jshint = require('gulp-jshint');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var notify = require('gulp-notify');
var browserSync   = require('browser-sync');

// Compile Our Sass
gulp.task('sass', function() {
    return gulp.src('scss/*.scss')
    .pipe(sass({ style: 'compressed' }))
    .pipe(gulp.dest('css'));
});

// Watch Files For Changes
gulp.task('watch', function() {
    gulp.watch('js/*.js', ['scripts']);
    gulp.watch('scss/*.scss', ['sass']);
});

// Lint Task
gulp.task('lint', function() {
    return gulp.src('js/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// Concatenate & Minify JS
gulp.task('scripts', function() {
    return gulp.src('js/*.js')
        .pipe(concat('all.js'))
        .pipe(gulp.dest('dist'))
        .pipe(uglify())
        .pipe(rename('all.min.js'))
        .pipe(gulp.dest('dist'))
});

// Browserificando
gulp.task('browser-sync', function() {
  browserSync.init( ['./**'], {
     server: {
            baseDir: "./"
        }
  });
});

// Default Task
gulp.task('default', ['sass', 'scripts', 'watch']); 