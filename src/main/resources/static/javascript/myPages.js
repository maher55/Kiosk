$(function () {
    let $myPages = $('#myPages');

    function updateCustomer(){
        let customerId = parseInt(localStorage.getItem("currentCustomer"))
        console.log(localStorage.getItem("currentCustomer"));
        let customer = {
            "name": $('#name').val(),
            "email": $('#email').val(),
            "phoneNumber": $('#phoneNumber').val()
        }
        $.ajax({
            type: 'PUT',
            url: 'api/customers/' + customerId,
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(customer),
            success: function (customer) {
          buildConfirmationScreen(customer);
            },
            error: function () {
                alert('Det gick inte att uppdatera dina uppgifter.');
            }
        });
    }
    function buildConfirmationScreen(customer){
    $myPages.html(`<div>
                        <h4> Kunddetaljer för ${customer.name} är nu registrerade!</h4> 
                    </div>`);
    }
    $('#finalise').on('click', () => {
        updateCustomer()
    })
})