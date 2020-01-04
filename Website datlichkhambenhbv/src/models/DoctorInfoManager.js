export default class DoctorInfoManager{
    static DoctorInfoManagerInstance = null;
    doctorInfo=false;
    Observers = [];
    addObserver(observer) {
        this.Observers[this.Observers.length] = observer
    }
    removeObserver(o){
        this.Observers = this.Observers.filter((observer) => observer != o );
    }
    static getDoctorInfoManagerInstance(){
        if(DoctorInfoManager.DoctorInfoManagerInstance == null){
            DoctorInfoManager.DoctorInfoManagerInstance = new DoctorInfoManager();
            this.DoctorInfoManagerInstance.loadDataFromLocal();  
        }
        return this.DoctorInfoManagerInstance;
    }

    getDoctorInfo(){
        return this.doctorInfo;
    }
    updateDoctorInfo(doctorInfo){
        this.doctorInfo = doctorInfo;
        this.updateDataToLocal();
    }
    deleteDoctorInfo(){
        this.doctorInfo = false;
        this.updateDataToLocal();
    }
    updateDataToLocal(){
        localStorage.removeItem("DoctorInfo")
        localStorage.setItem("DoctorInfo", JSON.stringify(this.doctorInfo))
        this.listenChange()
    }
    loadDataFromLocal(){

        var result = localStorage.getItem("DoctorInfo");
        if(result !== undefined && JSON.parse(result) !== false){
            
            this.doctorInfo = JSON.parse(result)
           
        } else{
            this.doctorInfo = false;
        }
        this.listenChange()
    }

    listenChange(){
        this.Observers.map(
            (o, index, arr)=>{
                if (o.onDoctorInfoChanged){
                    o.onDoctorInfoChanged(this)
                }
            }
        )
    }
}