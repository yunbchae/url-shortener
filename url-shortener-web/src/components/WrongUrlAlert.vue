<template>
    <div id="alert" class="alert" v-show="!isUrl">
        <span class="closebtn" @click="close">&times;</span>
        🤐 올바른 URL 형식이 아닙니다.
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        name: "Alert",
        computed: {
            ...mapGetters(['getIsUrl'])
        },
        methods: {
            close() {
                this.$store.commit('setIsUrl', true);
            }
        },
        data: () => ({
            isUrl: true
        }),
        created() {
            this.$store.watch(
                () => this.getIsUrl,
                (isUrl) => {
                    this.isUrl = isUrl;
                    if(!isUrl){
                        window.setTimeout(() =>  this.close(), 5000);
                    }
                }
            )
        }
    }
</script>

<style scoped>
    .alert {
        width: 23%;
        padding: 10px;
        background-color: #f44336;
        color: white;
        border-radius: 5px;
        font-size: 12px;
        position: absolute;
        left: 25%;
        top: 22%;
    }

    .closebtn {
        margin-left: 15px;
        color: white;
        font-weight: bold;
        float: right;
        font-size: 22px;
        line-height: 12px;
        cursor: pointer;
        transition: 0.3s;
    }

    .closebtn:hover {
        color: black;
    }
</style>