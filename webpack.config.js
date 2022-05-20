const miniCssExtractPlugin = require('mini-css-extract-plugin');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

module.exports = {
  mode: 'development',
  entry: {
    'polyfills': './src/polyfills.ts',
    'app': './src/main.ts',
    'styles': ['./src/styles.css', "./node_modules/@angular/material/prebuilt-themes/indigo-pink.css"]
  },
  output:{
    path: path.resolve(__dirname, 'dist'),     // путь к каталогу выходных файлов - папка public
    publicPath: '/',
    filename: '[name].[fullhash].js'
  },
  resolve: {
    extensions: ['.ts', '.js']
  },
  module:{
    rules:[   //загрузчик для ts
      {
        test: /\.ts$/, // определяем тип файлов
        use: [
          {
            loader: 'ts-loader',
            options: { configFile: path.resolve(__dirname, 'tsconfig.json') }
          } ,
          'angular2-template-loader'
        ]
      }, {
        test: /\.html$/,
        loader: 'html-loader'
      },{
        test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[fullhash].[ext]',
        }
      },{
        test: /\.css$/,
        exclude: path.resolve(__dirname, 'src/app'),
        //loader: MiniCssExtractPlugin.extract({fallback: 'style-loader', loader: 'css-loader'}),
        use: [
          MiniCssExtractPlugin.loader,
          "css-loader"
        ]
      },{
        test: /\.css$/,
        include: path.resolve(__dirname, 'src/app'),
        use: ['to-string-loader', 'css-loader']
      }
    ]
  },
  plugins: [
    new webpack.ContextReplacementPlugin(
      /angular(\\|\/)core/,
      path.resolve(__dirname, 'src'), // каталог с исходными файлами
      {} // карта маршрутов
    ),
    new HtmlWebpackPlugin({
      template: 'src/index.html'
    }),
    new MiniCssExtractPlugin({
      filename: "[name].css"
    }),
    new webpack.NoEmitOnErrorsPlugin(),
    new webpack.LoaderOptionsPlugin({
      htmlLoader: {
        minimize: false
      }
    })
  ]
}
