var app = new Vue({
    el: '#app',
    data: {
        blocks:[],
        
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
        }
    },
    mounted(){
        this.getRecentBlocks();
    }
})