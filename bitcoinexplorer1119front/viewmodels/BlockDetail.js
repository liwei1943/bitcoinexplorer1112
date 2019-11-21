var app = new Vue({
    el: '#app',
    data: {

        blockhash: "",
        BlcokDetail: {},
        total: 0,
        pageSize: 10,
        txPageinfo: [],
        Transactions:[]
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
                app.txPageinfo = response.data.list;
                app.total = response.data.total;
                app.pageSize = response.data.pageSize;
                console.log(response.data.list.txDetails+
                    '222222')

                    app.txPageinfo.forEach(element => {
                        app.Transactions=element.txDetails;
                        console.log(element.txDetails+"33333")
                    });
            })
                .catch(function (error) {
                    console.log(error);
                });
        },
        currentChange(val) {
            this.page = val;
            this.getTransactionByBlockhashWithPage(this.page);
        }
    },
    mounted() {
        var url = new URL(location.href);
        this.blockhash = url.searchParams.get("blockhash");
        this.getBlockByBlockHash();
        this.getTransactionByBlockhashWithPage();
    }
})