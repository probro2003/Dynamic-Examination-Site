 $(document).ready(function() {
            $('form').submit(function(e) {
//            	alert("error occurred");
                e.preventDefault();
                
                var email = $('#email').val();
                var dob = $('#dob').val();
                var newpassword = $('#newpassword').val();
                var confirmpassword = $('#confirmpassword').val();

                $.ajax({
                    type: 'POST',
                    url: 'reset',
                    data: {
                        email: email,
                        dob: dob, 
                        newpassword: newpassword,
                        confirmpassword: confirmpassword
                       
                        
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