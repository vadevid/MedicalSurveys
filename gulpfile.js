const gulp = require('gulp');
const webpackStream = require('webpack-stream');
const WebpackDevServer 	 = require('webpack-dev-server');
const webpack = require('webpack');
const webpackConfig = require('./webpack.config.js');
const runSeq = require('gulp4-run-sequence');
const webpackDevServer = require('webpack-dev-server');
const browserSync = require('browser-sync');
const BrowserSyncPlugin  = require('browser-sync-webpack-plugin');
const gutil = require('gulp-util');
const sourcemaps = require('gulp-sourcemaps');
const uglify = require('gulp-uglify');
const maven = require('gulp-maven-deploy');
const zip = require('gulp-zip');

let browserSyncInstance;
//
// gulp.task('default',  () => {
//   return gulp
//     .src('./src/main.ts')
//     .pipe(webpackStream(webpackConfig), webpack)
//     .pipe(gulp.dest('./dist/'));
// });
// gulp.task('serve', () => {
//   const servername = 'serverebat';
//   const bsConfig = {
//     host: 'localhost',
//     port: 4000
//   };
//   const bspluginConfig = {
//     reload: false,
//     name: servername,
//     callback: () => { browserSyncInstance = browserSync.get(servername) }
//   };
//
//   const _config = Object.create(webpackConfig);
//   // const _config = Object.assign(webpackConfig, {
//   //   plugins: [
//   //     new BrowserSyncPlugin(bsConfig, bspluginConfig),
//   //   ]
//   // })
//   const config = webpack(_config);
//
//   new WebpackDevServer(config, /* _config.devServer,*/ { publicPath: webpackConfig.output.publicPath }).listen(8080, 'localhost', (err) => {
//     if(err) throw new gutil.PluginError("webpack-dev-server", err);
//     gutil.log("[webpack-dev-server]", "http://localhost:8080/webpack-dev-server/index.html");
//   })
//
// })

const path = {
  HTML: 'src/index.html',
  ALL: ['src/**/*.ts', 'src/**/*.js'],
  MANIFIED_OUT: 'build.min.js',
  DEST_SRC: 'dist/src',
  DEST_BUILD: 'dist/build',
  DEST: 'dist'
};

gulp.task('webpack', ()=>{
  return gulp.src(path.ALL)
    .pipe(sourcemaps.init())
    .pipe(webpackStream(webpackConfig))
    .pipe(uglify())
    .pipe(gulp.dest(path.DEST_BUILD));
});

gulp.task('deploy', () => {
  return gulp.src('../MicronautServer/LabRsMicronaut')
    .pipe(zip('labrsmicronaut.war'))
    .pipe(maven.install({
      'groupId' : 'com.'
    }))
})


gulp.task('webpack-dev-server', (callback) => {
  const myConfig = Object.create(webpackConfig);
  myConfig.devtool = 'eval';

  new WebpackDevServer(webpack(myConfig), {
  }).listen(8080, 'localhost', (err) => {
    if (err) throw new gutil.PluginError('webpack-dev-server', err);
    gutil.log("[webpack-dev-server]", "http://localhost:8080/webpack-dev-server/index.html")
  })
})

gulp.task('watch', () => {
  gulp.watch( gulp.series(path.ALL , 'webpack'))
})

gulp.task('default', gulp.series( /*'deploy', */'webpack-dev-server', 'watch'))
