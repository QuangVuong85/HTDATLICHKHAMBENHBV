export default class UserInfoManager{
    static UserInfoManagerInstance = null;
    userInfo=false;
    Observers = [];
    addObserver(observer) {
        this.Observers[this.Observers.length] = observer
    }
    removeObserver(o){
        this.Observers = this.Observers.filter((observer) => observer != o );
    }
    static getUserInfoManagerInstance(){
        if(UserInfoManager.UserInfoManagerInstance == null){
            UserInfoManager.UserInfoManagerInstance = new UserInfoManager();
            this.UserInfoManagerInstance.loadDataFromLocal();  
        }
        return this.UserInfoManagerInstance;
    }

    getUserInfo(){
        return this.userInfo;
    }
    updateUserInfo(userInfo){
        this.userInfo = userInfo;
        this.updateDataToLocal();
    }
    deleteUserInfo(){
        this.userInfo = false;
        this.updateDataToLocal();
    }
    updateDataToLocal(){
        localStorage.removeItem("UserInfo")
        localStorage.setItem("UserInfo", JSON.stringify(this.userInfo))
        this.listenChange()
    }
    loadDataFromLocal(){

        var result = localStorage.getItem("UserInfo");
        if(result !== undefined && JSON.parse(result) !== false){
            
            this.userInfo = JSON.parse(result)
           
        } else{
            this.userInfo = false;
        }
        this.listenChange()
    }

    listenChange(){
        this.Observers.map(
            (o, index, arr)=>{
                if (o.onUserInfoChanged){
                    o.onUserInfoChanged(this)
                }
            }
        )
    }
}