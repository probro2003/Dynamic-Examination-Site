 $(document).ready(function() {
            $('form').submit(function(e) {
//            	alert("error occurred");
                e.preventDefault();
                
                var username = $('#username').val();
                var email = $('#email').val();
                var dob = $('#dob').val();
                var password = $('#password').val();
                var conpass = $('#conpass').val();

                $.ajax({
                    type: 'POST',
                    url: 'register',
                    data: {
                        username: username,
                        email: email,
                        dob: dob, 
                        password: password,
                        conpass: conpass
                       
                        
                    },
                    success: function(response) {
                        if (response == "success") {
//                        	alert("inside");
                        	$('.popup').show();
                            
                        } else {
                            alert("password not same");
                        }
                    },
                    error: function() {
                        alert('An error occurred during sign up.');
                    }
                });
            });
            
            $(document).on('click', function(e) {
                if ($(e.target).is('.popup')) {
                    $('.popup').hide();
                }
            });
        });