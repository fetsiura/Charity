document.addEventListener("DOMContentLoaded", function() {


    window.onload = function() {
        const pocketChange = document.getElementById('pocketChange')

        const quantityInputValue = document.getElementById('quantityValue')
        const quantitySummary = document.getElementById('quantitySummary')

        const categoryInputValue = document.querySelectorAll('#categoryInputValue')
        const categorySummary = document.getElementById('categorySummary')

        const institutionValue = document.querySelectorAll('#institutionValue')
        const institutionSummary = document.getElementById('institutionSummary')

        const cityInputValue = document.getElementById('cityInputValue')
        const citySummary = document.getElementById('citySummary')
        const citySummarySecond = document.getElementById('citySummarySecond')

        const streetInputValue = document.getElementById('streetInputValue')
        const streetSummary = document.getElementById('streetSummary')


        const zipInputValue = document.getElementById('zipInputValue')
        const zipSummary = document.getElementById('zipSummary')

        const phoneInputValue = document.getElementById('phoneInputValue')
        const phoneSummary = document.getElementById('phoneSummary')

        const dateInputValue = document.getElementById('dateInputValue')
        const dateSummary = document.getElementById('dateSummary')

        const timeInputValue = document.getElementById('timeInputValue')
        const timeSummary = document.getElementById('timeSummary')

        const commentInputValue = document.getElementById('commentInputValue')
        const commentSummary = document.getElementById('commentSummary')


        cityInputValue.addEventListener('input', function() {
            citySummary.innerText = cityInputValue.value;
            citySummarySecond.innerText = cityInputValue.value;
            streetSummary.innerText = streetInputValue.value;
        });

        zipInputValue.addEventListener('input', function() {
            zipSummary.innerText = zipInputValue.value;
        });
        phoneInputValue.addEventListener('input', function() {
            phoneSummary.innerText = phoneInputValue.value;
        });

        dateInputValue.addEventListener('input', function() {
            dateSummary.innerText = dateInputValue.value;
        });

        timeInputValue.addEventListener('input', function() {
            timeSummary.innerText = timeInputValue.value;
        });


        commentInputValue.addEventListener('input', function() {
            commentSummary.innerText = commentInputValue.value;
        });



        quantityInputValue.addEventListener('input', function() {
            quantitySummary.innerText = quantityInputValue.value;

            if(quantityInputValue.value<2 ){
                pocketChange.innerText='worek'
            } else if(quantityInputValue.value>1 && quantityInputValue.value<5){
                pocketChange.innerText='worki'
            } else if(quantityInputValue.value>4){
                pocketChange.innerText='worków'
            }

        });

        categoryInputValue.forEach(el => {
                el.addEventListener('input', function (){
                    if(el.value<2){
                        categorySummary.innerText='ubrań, które nadają się do ponownego użycia'
                    }
                    if(el.value>1 && el.value<3){
                        categorySummary.innerText='ubrania, do wyrzucenia'
                    }
                    if(el.value>2 && el.value<4){
                        categorySummary.innerText='zabawek'
                    }
                    if(el.value>3 && el.value<5){
                        categorySummary.innerText='książek'
                    }
                    if(el.value>4 && el.value<6){
                        categorySummary.innerText='innego'
                    }
                })
            }
        )

        institutionValue.forEach(el => {
        el.addEventListener('input', function (){
            institutionSummary.innerText = el.dataset.institution
        })})
    }


});
