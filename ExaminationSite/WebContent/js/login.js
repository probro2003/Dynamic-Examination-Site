 $(document).ready(function() {
            $('form').submit(function(e) {
//            	alert("error occurred");
                e.preventDefault();
                
                var username = $('#username').val();
                var password = $('#password').val();

                $.ajax({
                    type: 'POST',
                    url: 'login',
                    data: {
                        username: username,
                        password: password
                    },
                    success: function(response) {
                        if (response == "success") {
//                        	alert("inside");
                            window.location.href = 'startpage.jsp';
                            
                        } else {
                            $('.popup').show();
//                            alert("password is wrong");
                        }
                    },
                    error: function() {
                        alert('An error occurred during login.');
                    }
                });
            });
            
            $(document).on('click', function(e) {
                if ($(e.target).is('.popup')) {
                    $('.popup').hide();
                }
            });
        });