var app = new Vue({
    el: '#app',
    data: {
        transactions:[],
        
    },
    methods:{
        getRecentTransactions(){
            axios.get("/transaction/getRecentUnconfirmed")
            .then(function (response) {
                console.log(response);
                app.transactions = response.data;
            })
            .catch(function (error) {
                console.log(error);
            });
        },
        toTransaction(){
            window.location.href="Transaction";
        },
        toBlock(){
            window.location.href="RecentBlock";
        }
    },
    mounted(){
        this.getRecentTransactions();
    }
})