<script>
    (function (selector) {

        let start_pos = 2;  // start from 2 pixel left
        let end_pos = document.querySelector("#container").getBoundingClientRect().width - 100;

        let interval = setInterval(function () {

            if(selector.offsetLeft >= end_pos) {
                start_pos = 2;
            } else {
                start_pos++;
            }


            selector.style = `left: ${start_pos}px`;

        }, 10);
    })(document.querySelector("#car"));
</script>