public class HostedApp extends Service{
    public int diskSpace;
    public int usedDiskSpace;
    public int downloadBits;
    public int usedDownloadBits;

    public double calculatePrice(){
        double price = 0;
        double extraDisk = Math.floor((usedDiskSpace - diskSpace) / 10);
        double extraDownload = Math.floor((usedDownloadBits - downloadBits) / 100);

        if(usedDiskSpace < diskSpace){
            price += super.basePrice / 100;
        }else{
            price += (super.basePrice / 100) + extraDisk * (0.5 * (super.basePrice / 100));
        }

        if(usedDownloadBits < downloadBits){
            price += 2 * (super.basePrice / 100);
        }else{
            price += 2 * (super.basePrice / 100) + extraDownload * (super.basePrice / 100);
        }
        return price;
    }
}