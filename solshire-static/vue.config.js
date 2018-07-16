module.exports = {
  css: {
    extract: false
  },
  devServer: {
    proxy: {
      "/solshire": {
        target: "http://bkwater.org",
        changeOrigin: true
      }
    }
  }
};
