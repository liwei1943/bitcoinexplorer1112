var app = new Vue({
    el: '#app',
    data: {

        blockhash: "",
        BlcokDetail: {},
        page: 1,
        total: 0,
        pageSize: 10,
        txPageinfo: "",
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
        },
        getTransactionByBlockhashWithPage() {
            axios.get("/transaction/getTransactionByBlockhashWithPage", { params: { blockhash: this.blockhash, page: this.page } }).then(function (response) {
                console.log(response);
                app.txPageinfo = response.data;
                app.page = response.data.page;
                app.total = response.data.total;
                app.pageSize = response.data.pageSize;
            })
                .catch(function (error) {
                    console.log(error);
                });
        },
        handleSizeChange(val) {
            this.pageSize = val;
            this.getTransactionByBlockhashWithPage(this.page, this.pageSize);
        },
        //当前页
        handleCurrentChange(val) {
            this.page = val;
            this.getTransactionByBlockhashWithPage(this.page, this.pageSize);
        }
    },
    mounted() {
        var url = new URL(location.href);
        this.blockhash = url.searchParams.get("blockhash");
        this.getBlockByBlockHash();
        this.getTransactionByBlockhashWithPage();
    }
})