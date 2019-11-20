var app = new Vue({
    el: '#app',
    data: {

        txhash: "",
        TransactionDetail: {},
    },
    methods: {
        getByTxhash() {
            axios.get("/transaction/getByTxhash", { params: { txhash: this.txhash } }).then(function (response) {
                console.log(response);
                app.TransactionDetail = response.data;
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        var url = new URL(location.href);
        this.txhash = url.searchParams.get("txhash");
        this.getByTxhash();
    }
})