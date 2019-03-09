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
        CSP axtel = new CSP();
        axtel.name = "Axtel";
        
        if(media.equals("optic")){

            InternetConnection optic = new InternetConnection();
            optic.basePrice = 350;
            optic.baseMb = 20;
            optic.costPerMb = 1;
            optic.usedMb = usedMb;
            axtel.addService(optic);

        }else if(media.equals("satellite")){

            InternetConnection satellite = new InternetConnection();
            satellite.basePrice = 5000;
            satellite.baseMb = 10;
            satellite.costPerMb = 10;
            satellite.usedMb = usedMb;
            axtel.addService(satellite);
        }
        
        TelephoneFixedCost unlimitedNational = new TelephoneFixedCost();
        unlimitedNational.basePrice = 20;
        axtel.addService(unlimitedNational);

        return axtel;
    }

    public CSP createInfinitum(int calls, double usedMb, int cellMins) {
        
        CSP infinitum = new CSP();
        infinitum.name = "Infinitum";
        
        CellTelephoneCall cellPhone = new CellTelephoneCall();
        cellPhone.costPerMinute = 1;
        cellPhone.minutes = cellMins;
        infinitum.addService(cellPhone);

        InternetConnection internet = new InternetConnection();
        internet.basePrice = 200;
        internet.baseMb = 10;
        internet.costPerMb = 10;
        internet.usedMb = usedMb;
        infinitum.addService(internet);

        CellTelephoneCall localCall = new CellTelephoneCall();
        localCall.costPerMinute = 1;
        localCall.minutes = calls;
        infinitum.addService(localCall);

        return infinitum;
    }
}