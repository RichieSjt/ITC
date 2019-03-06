public class CSPFactory { 
    public CSP createATT(double usedMb, int channels) {
        CSP att = new CSP();
        att.name = "AT&T";
    
        InternetConnection ic = new InternetConnection();
        ic.basePrice = 40;
        ic.baseMb = 50;
        ic.costPerMb = 2;
        ic.usedMb = usedMb;
        att.addService(ic);
    
        PaidTV tv = new PaidTV();
        tv.basePrice = 40;
        tv.costPerChannel = 10;
        tv.channels = channels;
        att.addService(tv);
        
        TelephoneFixedCost tel = new TelephoneFixedCost();
        tel.basePrice = 20;
        att.addService(tel);
        return att;
    }

    public CSP createAxtel(String media, double usedMb) {
        /*
        CSP axtel = new CSP();
        axtel.name = "Axtel";
    
        InternetConnection ic = new InternetConnection();
        ic.basePrice = 40;
        ic.baseMb = 50;
        ic.costPerMb = 2;
        ic.usedMb = usedMb;
        axtel.addService(ic);
    
        PaidTV tv = new PaidTV();
        tv.basePrice = 40;
        tv.costPerChannel = 10;
        tv.channels = channels;
        axtel.addService(tv);
        
        TelephoneFixedCost tel = new TelephoneFixedCost();
        tel.basePrice = 20;
        axtel.addService(tel);
        return axtel;  */
        return null; 
    }

    public CSP createInfinitum(int calls, double usedMmb, int cellMins) {
        /*
        CSP infinitum = new CSP();
        infinitum.name = "Infinitum";
    
        InternetConnection ic = new InternetConnection();
        ic.basePrice = 40;
        ic.baseMb = 50;
        ic.costPerMb = 2;
        ic.usedMb = usedMb;
        infinitum.addService(ic);
    
        PaidTV tv = new PaidTV();
        tv.basePrice = 40;
        tv.costPerChannel = 10;
        tv.channels = channels;
        infinitum.addService(tv);
        
        TelephoneFixedCost tel = new TelephoneFixedCost();
        tel.basePrice = 20;
        infinitum.addService(tel);
        return infinitum; */
        return null;
    }
}