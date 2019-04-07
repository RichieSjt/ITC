public class Information<T> {
        private T generic;
        public void displayInformation(){
            System.out.println(generic);
        }
        public void setPerson(T generic){
            this.generic = generic;
        }
}