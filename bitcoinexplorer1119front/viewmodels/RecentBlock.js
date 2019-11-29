var app = new Vue({
    el: '#app',
    data: {
        blocks:[],
        keyword:"",
    },
    methods:{
        getRecentBlocks(){
            axios.get("/block/getRecentBlock")
            .then(function (response) {
                console.log(response);
                app.blocks = response.data;
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
        },
        OnSearch(){
            window.location.href="BlockDetail?blockhash="+this.keyword;
            
        }
    },
    mounted(){
        this.getRecentBlocks();
    }
})