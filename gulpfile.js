const gulp = require('gulp');
const shell = require('gulp-shell');

gulp.task('backend', shell.task(['java -jar ./server/labrsmicronaut-0.1.jar']))

gulp.task('serve', () => {
  return gulp.src('./').pipe(shell(['ng serve --open']))
})

gulp.task('default', gulp.parallel('backend', 'serve'))
