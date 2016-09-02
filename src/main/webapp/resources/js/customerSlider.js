(function() {
            var flag = 0;
            $('#details_panel').hide();
            $('#togle').on('click', function() {
                if (flag == 0) {
                    $('#details_panel').slideDown(500);
                    flag = 1;
                } else {
                    $('#details_panel').slideUp(500);
                    flag = 0;
                }
            });
        })();