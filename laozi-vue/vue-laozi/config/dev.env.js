'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // API_ROOT:'"http://127.0.0.1:8080"'
  API_ROOT:'"http://10.11.6.111:8080"'
})
