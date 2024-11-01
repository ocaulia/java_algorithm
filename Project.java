import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Node {
    DataObat data;
    Node prev;
    Node next;

    public Node(DataObat data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

//Membuat Doubly Linked List
public class Project {
    Node head; // head of the doubly linked list

    // Insert Node (Front)
    public void push() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID obat: ");
        int new_id = scanner.nextInt();
        if (search(new_id)) {
            System.out.println("ID obat sudah ada dalam database. Masukkan ID obat baru:");
            new_id = scanner.nextInt(); // Input new ID after displaying the message
        }
        System.out.print("Masukkan Nama obat: ");
        String new_nama = scanner.next();

        System.out.print("Masukkan Harga obat: RP. ");
        double new_harga = scanner.nextDouble();

        System.out.print("Masukkan Type obat: ");
        String new_type = scanner.next();

        System.out.print("Masukkan Stock obat: ");
        int new_stock = scanner.nextInt();

        System.out.print("Masukkan Tanggal Kadaluarsa obat: ");
        String new_tanggalKadaluarsa = scanner.next();

        // Create new DataObat object using the provided constructor
        DataObat new_dataObat = new DataObat(new_id, new_nama, new_harga, new_type, new_stock, new_tanggalKadaluarsa);

        /* 1. allocate node */
        Node new_Node = new Node(new_dataObat);

        /* 2. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 3. Change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 4. Move the head to point to the new node */
        head = new_Node;
    }

    //insert Node (in between)
    public void InsertAfter(Node prev_Node) {
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID obat: ");
        int new_id = scanner.nextInt();
        if (search(new_id)) {
            System.out.println("ID obat sudah ada dalam database. Masukkan ID obat baru:");
            new_id = scanner.nextInt(); // Input new ID after displaying the message
        }
        System.out.print("Masukkan Nama obat: ");
        String new_nama = scanner.next();

        System.out.print("Masukkan Harga obat: RP. ");
        double new_harga = scanner.nextDouble();

        System.out.print("Masukkan Type obat: ");
        String new_type = scanner.next();

        System.out.print("Masukkan Stock obat: ");
        int new_stock = scanner.nextInt();

        System.out.print("Masukkan Tanggal Kadaluarsa obat: ");
        String new_tanggalKadaluarsa = scanner.next();

        // Create new DataObat object using the provided constructor
        DataObat new_dataObat = new DataObat(new_id, new_nama, new_harga, new_type, new_stock, new_tanggalKadaluarsa);

        /* 2. allocate node * 3 put in the data */
        Node new_node = new Node(new_dataObat);

        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;

        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }
    }

    //insert Node (END)
    public void append() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID obat: ");
        int new_id = scanner.nextInt();
        if (search(new_id)) {
            System.out.println("ID obat sudah ada dalam database. Masukkan ID obat baru:");
            new_id = scanner.nextInt(); // Input new ID after displaying the message
        }

        System.out.print("Masukkan Nama obat: ");
        String new_nama = scanner.next();

        System.out.print("Masukkan Harga obat: RP. ");
        double new_harga = scanner.nextDouble();

        System.out.print("Masukkan Type obat: ");
        String new_type = scanner.next();

        System.out.print("Masukkan Stock obat: ");
        int new_stock = scanner.nextInt();

        System.out.print("Masukkan Tanggal Kadaluarsa obat: ");
        String new_tanggalKadaluarsa = scanner.next();

        // Create new DataObat object using the provided constructor
        DataObat new_dataObat = new DataObat(new_id, new_nama, new_harga, new_type, new_stock, new_tanggalKadaluarsa);

        /* 1. allocate node * 2 put in the data */
        Node new_node = new Node(new_dataObat);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    //print Data
    public void printData() {
        Node current = head;

        if (current == null) {
            System.out.println("No data available.");
            return;
        }

        System.out.println("==============================================================================================");
        System.out.println("                       Data Pengelolaan Obat - APOTEK REV&KA       ");
        System.out.println("==============================================================================================");
        System.out.printf("%-5s | %-25s | %-12s | %-10s | %-7s | %-15s\n",
                "ID", "Nama Obat", "Harga", "Type", "Stock", "Tanggal Kadaluarsa");
        System.out.println("----------------------------------------------------------------------------------------------");

        while (current != null) {
            System.out.printf("%-5d | %-25s | %-12.2f | %-10s | %-7d | %-15s\n",
                    current.data.id, current.data.nama, current.data.harga, current.data.type, current.data.stock, current.data.tanggalKadaluarsa);
            current = current.next;
        }

        System.out.println("==============================================================================================");
        System.out.println("Total Items: " + countTotalItems());
        System.out.println("==============================================================================================");
    }

    //sorting
    // Sort by stock using Bubble Sort (Ascending Order)
    public void sortByStock() {
        if (head == null) {
            System.out.println("No data available to sort.");
            return;
        }

        boolean swapped;
        Node last = null;

        do {
            swapped = false;
            Node current = head;

            while (current.next != last) {
                if (current.data.stock > current.next.data.stock) {
                    swapNodes(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    // Sort by name using Selection Sort (Ascending Order)
    public void sortByName() {
        if (head == null) {
            System.out.println("No data available to sort.");
            return;
        }

        Node current = head;

        while (current != null) {
            Node smallest = current;
            Node temp = current.next;

            while (temp != null) {
                if (temp.data.nama.compareTo(smallest.data.nama) < 0) {
                    smallest = temp;
                }
                temp = temp.next;
            }

            swapNodes(current, smallest);
            current = current.next;
        }
    }

    // Sort by ID using Insertion Sort (Ascending Order)
    public void sortByID() {
        if (head == null) {
            System.out.println("No data available to sort.");
            return;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.prev = current.next = null;
            sorted = insertSorted(sorted, current);
            current = nextNode;
        }

        head = sorted;
    }

    // Sort by harga using Bubble Sort (Ascending Order)
    public void sortByHarga() {
        if (head == null) {
            System.out.println("No data available to sort.");
            return;
        }

        boolean swapped;
        Node last = null;

        do {
            swapped = false;
            Node current = head;

            while (current.next != last) {
                if (current.data.harga > current.next.data.harga) {
                    swapNodes(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    // Helper method to insert a node into the sorted list based on ID
    private Node insertSorted(Node sorted, Node newNode) {
        if (sorted == null) {
            return newNode;
        }

        if (newNode.data.id < sorted.data.id) {
            newNode.next = sorted;
            sorted.prev = newNode;
            return newNode;
        }

        Node current = sorted;
        while (current.next != null && current.next.data.id < newNode.data.id) {
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;
        newNode.prev = current;

        return sorted;
    }

    // Helper method to swap two nodes in the doubly linked list
    private void swapNodes(Node node1, Node node2) {
        int tempID = node1.data.id;
        String tempNama = node1.data.nama;
        double tempHarga = node1.data.harga;
        String tempType = node1.data.type;
        int tempStock = node1.data.stock;
        String tempTanggalKadaluarsa = node1.data.tanggalKadaluarsa;

        node1.data.id = node2.data.id;
        node1.data.nama = node2.data.nama;
        node1.data.harga = node2.data.harga;
        node1.data.type = node2.data.type;
        node1.data.stock = node2.data.stock;
        node1.data.tanggalKadaluarsa = node2.data.tanggalKadaluarsa;

        node2.data.id = tempID;
        node2.data.nama = tempNama;
        node2.data.harga = tempHarga;
        node2.data.type = tempType;
        node2.data.stock = tempStock;
        node2.data.tanggalKadaluarsa = tempTanggalKadaluarsa;
    }

    // delete node by reference key
    public boolean deleteNode(int key) {
        Node temp = head, prev = null;

        // If node to be deleted is head node
        if (temp != null && temp.data.id == key) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        } else {
            while (temp != null) {
                if (temp.data.id == key) {
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        if (temp == null) {
            return false; // Data dengan ID yang dicari tidak ditemukan
        }

        prev.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = prev;
        }

        return true;
    }

    //searching
    //search node berdasarkan id
    public boolean search(int x) {
        Node current = head;

        while (current != null) {
            if (current.data.id == x) {
                return true; // data found
            }
            current = current.next;
        }

        return false; // data not found
    }

    public boolean searchByName(String name) {
        Node current = head;

        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false ;
    }

    public boolean searchByType(String type) {
        Node current = head;

        while (current != null) {
            if (current.data.type.equalsIgnoreCase(type)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Edit data by ID
    public void editData(int id) {
        Node current = head;

        while (current != null) {
            if (current.data.id == id) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Masukkan Nama obat baru: ");
                String newNama = scanner.next();

                System.out.print("Masukkan Harga obat baru: RP. ");
                double newHarga = scanner.nextDouble();

                System.out.print("Masukkan Type obat baru: ");
                String newType = scanner.next();

                System.out.print("Masukkan Stock obat baru: ");
                int newStock = scanner.nextInt();

                System.out.print("Masukkan Tanggal Kadaluarsa obat baru: ");
                String newTanggalKadaluarsa = scanner.next();

                current.data.nama = newNama;
                current.data.harga = newHarga;
                current.data.type = newType;
                current.data.stock = newStock;
                current.data.tanggalKadaluarsa = newTanggalKadaluarsa;

                System.out.println("informasi obat untuk ID obat " + id + " telah diperbarui.");
                return;
            }
            current = current.next;
        }

        System.out.println("Data dengan ID " + id + " tidak ditemukan.");
    }

    public void readFromFile() {
        try {
            File file = new File("warehouse_stock.txt");
            if (!file.exists()) {
                System.out.println("Tidak ada data stok sebelumnya yang ditemukan. Membuat file baru.");
                file.createNewFile();
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                int id = lineScanner.nextInt();
                String nama = lineScanner.next();
                double harga = lineScanner.nextDouble();
                String type = lineScanner.next();
                int stock = lineScanner.nextInt();
                String tanggalKadaluarsa = lineScanner.next();

                // Create a DataObat object using the extracted fields
                DataObat dataObat = new DataObat(id, nama, harga, type, stock, tanggalKadaluarsa);

                // Create a Node with the DataObat object
                Node new_Node = new Node(dataObat);

                new_Node.next = head;
                new_Node.prev = null;
                if (head != null)
                    head.prev = new_Node;
                head = new_Node;

                lineScanner.close();
            }

            scanner.close();
            System.out.println("Stock data loaded from the file.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("invoice_obat.txt");
            Node current = head;
            // Write header for the invoice
            writer.write("==============================================================================================\n");
            writer.write("                                INVOICE OBAT - APOTEK REV&KA                                \n");
            writer.write("==============================================================================================\n");
            writer.write(String.format("%-5s | %-25s | %-12s | %-10s | %-7s | %-15s\n",
                    "ID", "Nama Obat", "Harga", "Type", "Stock", "Tanggal Kadaluarsa"));
            writer.write("----------------------------------------------------------------------------------------------\n");

            // Write data for each node in the doubly linked list
            while (current != null) {
                writer.write(String.format("%-5d | %-25s | %-12.2f | %-10s | %-7d | %-15s\n",
                        current.data.id, current.data.nama, current.data.harga, current.data.type, current.data.stock, current.data.tanggalKadaluarsa));
                current = current.next;
            }

            // Write footer for the invoice
            writer.write("----------------------------------------------------------------------------------------------\n");
            writer.write("Total Items: " + countTotalItems() + "\n");
            writer.write("Total Price: Rp. " + calculateTotalPrice() + "\n");
            writer.write("==============================================================================================\n\n");
            writer.close();
            System.out.println("Stock data saved to 'invoice_obat.txt'.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Calculate the total number of items in the list
    public int countTotalItems() {
        int totalItems = 0;
        Node current = head;
        while (current != null) {
            totalItems += current.data.stock;
            current = current.next;
        }
        return totalItems;
    }

    // Calculate the total price of all items in the list
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        Node current = head;
        while (current != null) {
            totalPrice += current.data.harga * current.data.stock;
            current = current.next;
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();

        // Read data from the file (if available)
        project.readFromFile();

        int choice;
        //looping do while
        do {
            System.out.println(" ");
            System.out.println("==============================================================================================");
            System.out.println("====================================== APOTEK REV&KA =========================================");
            System.out.println("1. Masukan Informasi obat berdasarkan Node bagian depan");
            System.out.println("2. Masukan Informasi obat berdasarkan Node bagian tengah");
            System.out.println("3. Masukan Informasi obat berdasarkan Node bagian belakang");
            System.out.println("4. Delete informasi obat");
            System.out.println("5. Proses pencarian data informasi obat");
            System.out.println("6. Print informasi obat");
            System.out.println("7. Edit informasi obat berdasarkan ID");
            System.out.println("0. keluar Program pengelolaan informasi");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            //conditional statement
            switch (choice) {
                case 1:
                    project.push();
                    break;
                case 2:
                    System.out.print("Masukkan ID node informasi obat yang ingin Anda masukkan: ");
                    int idToInsertAfter = scanner.nextInt();
                    // Search the node with the given ID
                    Node prevNode = project.head;
                    while (prevNode != null && prevNode.data.id != idToInsertAfter) {
                        prevNode = prevNode.next;
                    }
                    if (prevNode == null) {
                        System.out.println("Node with ID " + idToInsertAfter + " tidak ditemukan.");
                    } else {
                        project.InsertAfter(prevNode);
                    }
                    break;
                case 3:
                    project.append();
                    break;
                case 4:
                    System.out.print("Masukkan ID informasi obat yang ingin dihapus: ");
                    int idToDelete = scanner.nextInt();
                    boolean isDeleted = project.deleteNode(idToDelete);
                    if (isDeleted) {
                        System.out.println("Obat dengan ID " + idToDelete + " telah berhasil dihapus.");
                    } else {
                        System.out.println("Data with ID " + idToDelete + " not found. Tidak ada obat dengan ID tersebut.");
                    }
                    break;

                case 5:
                    int searchChoice;
                    //searching
                    do {
                        System.out.println("==================== Pencarian Data ====================");
                        System.out.println("1. Cari berdasarkan nama obat");
                        System.out.println("2. Cari berdasarkan ID obat");
                        System.out.println("3. Cari berdasarkan tipe obat");
                        System.out.println("0. Kembali ke menu utama");
                        System.out.print("Enter your choice: ");
                        searchChoice = scanner.nextInt();
                        //conditional statement
                        switch (searchChoice) {
                            case 1:
                                System.out.print("Masukkan Nama obat yang ingin dicari: ");
                                String searchNama = scanner.next();
                                Node currentNama = project.head;
                                boolean isFoundNama = false;

                                System.out.println("==================== Pencarian Data ====================");
                                System.out.println("Hasil pencarian berdasarkan nama obat : " + searchNama);

                                while (currentNama != null) {
                                    if (currentNama.data.nama.equalsIgnoreCase(searchNama)) {
                                        System.out.println("Pencarian informasi obat berdasarkan Nama = " + searchNama);
                                        System.out.println("ID: " + currentNama.data.id);
                                        System.out.println("Nama: " + currentNama.data.nama);
                                        System.out.println("Harga: " + currentNama.data.harga);
                                        System.out.println("Type: " + currentNama.data.type);
                                        System.out.println("Stock: " + currentNama.data.stock);
                                        System.out.println("Tanggal Kadaluarsa: " + currentNama.data.tanggalKadaluarsa);
                                        System.out.println("-------------------------------------------------------");
                                        isFoundNama = true;
                                    }
                                    currentNama = currentNama.next;
                                }

                                if (!isFoundNama) {
                                    System.out.println("Tidak ada data dengan nama obat '" + searchNama + "' ditemukan.");
                                }
                                break;
                            case 2:
                                System.out.print("Masukkan ID obat yang ingin dicari: ");
                                int searchID = scanner.nextInt();
                                Node current = project.head;
                                boolean isFound = false;

                                System.out.println("==================== Pencarian Data ====================");
                                System.out.println("Hasil pencarian berdasarkan ID obat: " + searchID);

                                while (current != null) {
                                    if (current.data.id == searchID) {
                                        System.out.println("Pencarian informasi obat berdasarkan ID = " + searchID );
                                        System.out.println("Hasil pencarian untuk ID obat : " + searchID);
                                        System.out.println("Data of the found node:");
                                        System.out.println("ID: " + current.data.id);
                                        System.out.println("Nama: " + current.data.nama);
                                        System.out.println("Harga: " + current.data.harga);
                                        System.out.println("Type: " + current.data.type);
                                        System.out.println("Stock: " + current.data.stock);
                                        System.out.println("Tanggal Kadaluarsa: " + current.data.tanggalKadaluarsa);
                                        System.out.println("-------------------------------------------------------");
                                        isFound = true;
                                        break;
                                    }
                                    current = current.next;
                                }

                                if (!isFound) {
                                    System.out.println("Node dengan ID " + searchID + " tidak ditemukan.");
                                }
                                break;
                            case 3:
                                System.out.print("Masukkan Tipe obat yang ingin dicari: ");
                                String searchType = scanner.next();
                                Node currentType = project.head;
                                boolean isFoundType = false;

                                System.out.println("==================== Pencarian Data ====================");
                                System.out.println("Hasil pencarian berdasarkan tipe obat: " + searchType);

                                while (currentType != null) {
                                    if (currentType.data.type.equalsIgnoreCase(searchType)) {
                                        System.out.println("Pencarian informasi obat berdasarkan Tipe = " + searchType);
                                        System.out.println("ID: " + currentType.data.id);
                                        System.out.println("Nama: " + currentType.data.nama);
                                        System.out.println("Harga: " + currentType.data.harga);
                                        System.out.println("Type: " + currentType.data.type);
                                        System.out.println("Stock: " + currentType.data.stock);
                                        System.out.println("Tanggal Kadaluarsa: " + currentType.data.tanggalKadaluarsa);
                                        System.out.println("-------------------------------------------------------");
                                        isFoundType = true;
                                    }
                                    currentType = currentType.next;
                                }

                                if (!isFoundType) {
                                    System.out.println("tidak ada data dengan tipe obat '" + searchType + "' ditemukan.");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (searchChoice != 0);
                    break;
                case 6:
                    int searchChoicea;
                    do {
                        System.out.println("==================== Print Informasi Obat ====================");
                        System.out.println("1. Print berdasarkan urutan nama obat");
                        System.out.println("2. Print berdasarkan urutan ID obat");
                        System.out.println("3. Print berdasarkan urutan stock obat");
                        System.out.println("4. Print berdasarkan urutan Harga obat");
                        System.out.println("0. Kembali ke menu utama");
                        System.out.print("pilih menu : ");
                        searchChoice = scanner.nextInt();
                        switch (searchChoice) {
                            case 1:
                                // Sort by name and print
                                project.sortByName();
                                project.printData();
                                break;
                            case 2:
                                // Sort by ID and print
                                project.sortByID();
                                project.printData();
                                break;
                            case 3:
                                // Sort by stock and print
                                project.sortByStock();
                                project.printData();
                                break;
                            case 4 :
                                // Sort by stock and print
                                project.sortByHarga();
                                project.printData();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("[Pilihan tidak tepat. Silakan coba lagi.]");
                        }
                    } while (searchChoice != 0);
                    break;
                case 7 :
                    System.out.print("Masukkan ID obat yang ingin di-edit: ");
                    int editID = scanner.nextInt();
                    project.editData(editID);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("[Pilihan tidak tepat. Silakan coba lagi.]");
            }
        } while (choice != 0);

        // Save data to the file before exiting
        project.writeToFile();

        scanner.close();
    }
}