var app = new Vue({
    el: '#app',
    data: {

        blockhash: "",
        BlcokDetail: {},
    },
    methods: {
        getBlockByBlockHash() {
            axios.get("/block/getInfoByHash", { params: { blockhash: this.blockhash } }).then(function (response) {
                console.log(response);
                app.BlcokDetail = response.data;
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        var url = new URL(location.href);
        this.blockhash = url.searchParams.get("blockhash");
        this.getBlockByBlockHash();
    }
})