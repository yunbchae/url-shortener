<template>
    <div class="wrap">
        <div class="search">
            <input type="text" id="shortUrl" class="searchTerm" placeholder="Copy short link" v-model="shortUrl" readonly />
            <button type="submit" class="searchButton" @click="copyUrl">📋</button>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        name: "ResultBar",
        computed: {
          ...mapGetters(['getShortUrl', 'getIsUrl'])
        },
        data: () => ({
            shortUrl: ""
        }),
        methods: {
            copyUrl() {
                let copyText = document.getElementById("shortUrl");
                copyText.select();
                copyText.setSelectionRange(0, 99999);
                document.execCommand("copy");
                this.$store.commit('setIsCopied', true);
            }
        },
        created() {
            this.$store.watch(
                () => this.getShortUrl,
                (shortUrl) => {
                    this.shortUrl = shortUrl;
                }
            );
            this.$store.watch(
                () => this.getIsUrl,
                (isUrl) => {
                    if(!isUrl){
                        this.$store.commit('setShortUrl', "");
                    }
                }
            );
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
        border: 3px solid #cc7300;
        border-right: none;
        padding: 5px;
        height: 40px;
        border-radius: 5px 0 0 5px;
        outline: none;
        color: black;
        font-size: 18px;
    }

    .searchButton {
        width: 60px;
        border: 1px solid #cc7300;
        background: #cc7300;
        text-align: center;
        color: #fff;
        border-radius: 0 5px 5px 0;
        cursor: pointer;
        font-size: 30px;
    }

    /*Resize the wrap to see the search bar change!*/
    .wrap{
        width: 25%;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>