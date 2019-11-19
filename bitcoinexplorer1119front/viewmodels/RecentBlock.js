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
        }
    },
    mounted(){
        this.getRecentBlocks();
    }
})