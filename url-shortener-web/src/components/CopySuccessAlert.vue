<template>
    <div id="alert" class="alert" v-show="isCopied">
        <span class="closebtn" @click="close">&times;</span>
        😃 복사되었습니다.
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        name: "Alert",
        computed: {
            ...mapGetters(['getIsCopied'])
        },
        data: () => ({
            isCopied: false
        }),
        methods: {
            close() {
                this.$store.commit('setIsCopied', false);
            }
        },
        created() {
            this.$store.watch(
                () => this.getIsCopied,
                (isCopied) => {
                    this.isCopied = isCopied;
                    if(isCopied){
                        window.setTimeout(() =>  this.close(), 3000);
                    }
                }
            )
        }
    }
</script>

<style scoped>
    .alert {
        width: 12%;
        padding: 10px;
        background-color: #22d028;
        color: white;
        border-radius: 5px;
        font-size: 12px;
        position: absolute;
        left: 37.5%;
        top: 43%;
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