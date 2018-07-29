tinymce.PluginManager.add('upload', function(editor, url) {
    // Add a button that opens a window
    editor.addButton('upload', {
        text: false,
        icon: 'image',
        tooltip:'插入/编辑图片',
        onclick: function() {
            editor.settings.uploadCallback(function(r){
                editor.execCommand('mceInsertContent', false, '<img src="' + r + '"/>');
            })
        }
    });

    // Adds a menu item to the tools menu
    editor.addMenuItem('upload', {
        text: '图片',
        context: 'insert',
        icon:'image',
        prependToContext:true,
        onclick: function() {
            editor.settings.uploadCallback(function(r){
                editor.execCommand('mceInsertContent', false, '<img src="' + r + '"/>');
            })
        }
    });
});