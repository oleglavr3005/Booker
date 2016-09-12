(function($) {
    $(document).on('mouseover','.vote-block li',function() {
        var $el = $(this);
        var star = parseInt($el.text(),10);

        if($el.parent().parent().hasClass('disabled')) {
            return false;
        }
    });
    $(document).on('click','.vote-block li',function() {
        var $el = $(this);
        var num = parseInt($el.text(),10);

        if($el.parent().parent().hasClass('disabled')) {
            return false;
        }
        //$el.parent().parent().addClass('disabled');
        $el.parent().find('.current span').css('width',num * 20 + '%');
        $el.parent().parent().find('#rate_span').html(num);
        return false;
    });
})($);
