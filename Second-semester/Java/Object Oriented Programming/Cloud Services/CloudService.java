public class CloudService{

    public Service requestAddOn(boolean firstTime){

        AddOn ao1 = new AddOn();
        ao1.basePrice = 50;
        ao1.firstTime = firstTime;

        return ao1;
    }
    public Service requestRentedApp(int releaseYear){

        RentedApp ra1 = new RentedApp();
        ra1.basePrice = 120;
        ra1.currentYear = 2019;
        ra1.releaseYear = releaseYear;

        return ra1;
    }
    public Service requestHostedApp(int usedDiskSpace, int usedDownloadBits){

        HostedApp ha1 = new HostedApp();
        ha1.basePrice = 200;
        ha1.diskSpace = 100;
        ha1.usedDiskSpace = usedDiskSpace;
        ha1.downloadBits = 1000;
        ha1.usedDownloadBits = usedDownloadBits;

        return ha1;
    }
}