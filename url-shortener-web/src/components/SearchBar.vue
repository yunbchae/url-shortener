<template>
    <div class="wrap">
        <div class="search">
            <input type="text" class="searchTerm" placeholder="Shorten your link" v-model="longUrl" @keypress.enter="shortenUrl" />
            <button type="submit" class="searchButton" @click="shortenUrl">✂</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SearchBar",
        data: () => ({
            longUrl: "",
            shortUrl: ""
        }),
        methods: {
            async shortenUrl() {
                if(this.checkUrl()){
                    await this.$store.dispatch('getShortUrl', {longUrl: this.longUrl});
                }else {
                    this.$store.commit('setIsUrl', false);
                }
            },
            checkUrl() {
                let regex = /^(((http(s?))\:\/\/)?)([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/;
                return regex.test(this.longUrl);
            }
        }
    }
</script>

<style scoped>
    body{
        background: #f2f2f2;
        font-family: 'Open Sans', sans-serif;
    }

    .search {
        width: 100%;
        position: relative;
        display: flex;
    }

    .searchTerm {
        width: 100%;
        border: 3px solid #00B4CC;
        border-right: none;
        padding: 5px;
        height: 50px;
        border-radius: 5px 0 0 5px;
        outline: none;
        color: #9DBFAF;
        font-size: 18px;
    }

    .searchTerm:focus{
        color: #00B4CC;
    }

    .searchButton {
        width: 60px;
        border: 1px solid #00B4CC;
        background: #00B4CC;
        text-align: center;
        color: #fff;
        border-radius: 0 5px 5px 0;
        cursor: pointer;
        font-size: 30px;
    }

    /*Resize the wrap to see the search bar change!*/
    .wrap{
        width: 50%;
        position: absolute;
        top: 30%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>