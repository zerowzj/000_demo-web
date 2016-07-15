(function (P) {
    var $this = null;
    $this = P.role = {
        //新增
        add: function () {
            var loading;
            var ajaxOptions = {
                target: '',
                url: '/role/add',
                type: 'POST',
                clearForm: false,
                beforeSubmit: function (formData, jqForm, options) {
                    loading = layer.load(1);
                    //loading = layer.msg('加载中', {icon: 16});
                    return true;
                },
                success: function (responseText, statusText, xhr, $form) {
                    layer.close(loading);
                    layer.msg('成功', {offset: 0});
                }
            };
            $('#_form').ajaxForm(ajaxOptions);
        }
    };
}(latte));