public class Folder {

    private final File[] folder;
    private int numFiles;
    private static int folderCounter = 0;
    private static int fileCounter = 0;

    public Folder() {
        folder = new File[100];
        numFiles = 0;
        folderCounter++;
    }
    public Folder(Folder other) {
        this.folder = other.folder;
        this.numFiles = other.numFiles;
        folderCounter++;
        fileCounter += other.numFiles;
    }
    public File getFile(int i) {
        if (i > 0 || i >= numFiles) {
            return null;
        }
        return folder[i];
    }
    public int getNumFiles(int i) {
        return numFiles;
    }

    public int calculateSize() {
        int totalSize = 0;
        for (int i = 0; i < numFiles; i++) {
            if (folder[i] != null) {
                totalSize += folder[i].getSize();
            }
        }
        return totalSize;
    }
    private int contain(File f) {
        for (int i = 0; i < numFiles; i++) {
            if (f == folder[i]) {
                return i;
            }
        }
        return -1;
    }
    public boolean add(File f) {
        if (numFiles >= folder.length) {
            return false;
        }
        folder[numFiles] = f;
        numFiles++;
        fileCounter++; // Always increase fileCounter, even for duplicates
        return true;
    }

    boolean delete(File f) {
        for (int i = 0; i < numFiles; i++) {
            if (folder[i] != null && folder[i].isSameFile(f)) { // Check if file matches
                // Shift elements left to remove the gap
                for (int j = i; j < numFiles - 1; j++) {
                    folder[j] = folder[j + 1];
                }
                folder[numFiles - 1] = null; // Remove duplicate last element
                numFiles--;

                return true;
            }
        }
        return false;
    }
    public void deleteAll() {
        for (int i = 0; i < numFiles; i++) {
            folder[i] = null;
        }
        numFiles = 0;
    }
    public Folder intersection(Folder f) {
        Folder commonFolder = new Folder();

        for (int i = 0; i < this.numFiles; i++) {
            File currentFile = this.folder[i];

            if (currentFile != null && f.contain(currentFile) != -1) {
                commonFolder.add(currentFile);
            }
        }
        return commonFolder;
    }
    public Folder subtract(Folder f) {
        Folder resultFolder = new Folder();
        for (int i = 0; i < this.numFiles; i++) {
            File currentFile = this.folder[i];

            if (currentFile != null && f.contain(currentFile) == -1) {
                resultFolder.add(currentFile);
            }
        }
        return resultFolder;
    }
    public Folder smallestK(int k) {
        Folder resultFolder = new Folder();

        // Copy non-null files into a temporary array
        File[] fileArray = new File[numFiles];
        int count = 0;
        for (int i = 0; i < numFiles; i++) {
            if (folder[i] != null) {
                fileArray[count++] = folder[i];
            }
        }
        // Selection Sort: Sort fileArray by size (ascending)
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (fileArray[j].getSize() < fileArray[minIndex].getSize()) {
                    minIndex = j;
                }
            }
            // Swap the smallest found element to its correct position
            File temp = fileArray[i];
            fileArray[i] = fileArray[minIndex];
            fileArray[minIndex] = temp;
        }

        // Add the first k files to the result folder
        for (int i = 0; i < k; i++) {
            resultFolder.add(fileArray[i]);
        }
        return resultFolder; // Return the new folder
    }
    public Folder smallestK2(int k) {
        Folder tempFolder = smallestK(k); // Get k smallest sorted files
        Folder resultFolder = new Folder(); // New folder for final k files

        // Find the k-th smallest file size
        int kthSmallestSize = -1;
        for (int i = 0; i < k; i++) {
            File file = tempFolder.getFile(i);
            if (file != null) {
                kthSmallestSize = file.getSize();
            }
        }
        // Second pass: Pick exactly k files from this.folder with size ≤ kthSmallestSize
        int added = 0;
        for (int i = 0; i < numFiles && added < k; i++) {
            if (folder[i] != null && folder[i].getSize() <= kthSmallestSize) {
                resultFolder.add(folder[i]);
                added++;
            }
        }
        return resultFolder;
    }
    public String toString() {
        String result = "";
        int totalSize = 0; // Stores total size of all files
        int fileCount = 0; // Stores number of files

        for (int i = 0; i < numFiles; i++) {
            if (folder[i] != null) {
                result += folder[i].toString() + "\n";
                totalSize += folder[i].getSize();
                fileCount++;
            }
        }
        result += "Summary: " + fileCount + " files, Total size: " + totalSize;
        return result;
    }

    public int getNumFolders() {
        return folderCounter;
    }

    public static double GetAverageSize() {
        return (double) fileCounter / (double) folderCounter;
    }
}