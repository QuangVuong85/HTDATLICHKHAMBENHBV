export default class AdminInfoManager{
    static AdminInfoManagerInstance = null;
    adminInfo=false;
    Observers = [];
    addObserver(observer) {
        this.Observers[this.Observers.length] = observer
    }
    removeObserver(o){
        this.Observers = this.Observers.filter((observer) => observer !== o );
    }
    static getAdminInfoManagerInstance(){
        if(AdminInfoManager.AdminInfoManagerInstance == null){
            AdminInfoManager.AdminInfoManagerInstance = new AdminInfoManager();
            this.AdminInfoManagerInstance.loadDataFromLocal();
        }
        return this.AdminInfoManagerInstance;
    }

    getAdminInfo(){
        return this.adminInfo;
    }
    updateAdminInfo(adminInfo){
        this.adminInfo = adminInfo;
        this.updateDataToLocal();
    }
    deleteAdminInfo(){
        this.adminInfo = false;
        this.updateDataToLocal();
    }
    updateDataToLocal(){
        localStorage.removeItem("AdminInfo")
        localStorage.setItem("AdminInfo", JSON.stringify(this.adminInfo))
        this.listenChange()
    }
    loadDataFromLocal(){

        const result = localStorage.getItem("AdminInfo");
        if(result !== undefined && JSON.parse(result) !== false){

            this.adminInfo = JSON.parse(result)

        } else{
            this.adminInfo = false;
        }
        this.listenChange()
    }

    listenChange(){
        this.Observers.map(
            (o, index, arr)=>{
                if (o.onAdminInfoChanged){
                    o.onAdminInfoChanged(this)
                }
            }
        )
    }
}
