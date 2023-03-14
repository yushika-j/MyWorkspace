public class SecurityAgent {
    
        private Combination secret;
        private DoorLock door;
        public SecurityAgent(Combination c, DoorLock l){
            secret = c;
            door = l;
        }
        public SecurityAgent(){
            int first = (int) (Math.random()*5) + 1;
            int second = (int) (Math.random()*5) + 1;
            int third = (int) (Math.random()*5) + 1;

            secret = new Combination(first, second, third);
        
            DoorLock doorlock = new DoorLock(secret);
            door = doorlock;
            

        }
        public DoorLock getDoorLock(){
            return door;
        }
        public void activateDoorLock(){
            door.activate(secret);
        }
    

}
