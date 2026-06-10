import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
                new Room(101, "Standard"),
                new Room(102, "Deluxe"),
                new Room(103, "Suite")
        };

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (!room.booked) {
                            System.out.println("Room " + room.roomNumber +
                                    " - " + room.category);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int bookRoom = sc.nextInt();

                    boolean foundBook = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == bookRoom) {
                            foundBook = true;

                            if (!room.booked) {
                                room.booked = true;
                                System.out.println("Room Booked Successfully!");
                            } else {
                                System.out.println("Room Already Booked!");
                            }
                        }
                    }

                    if (!foundBook) {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    boolean foundCancel = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == cancelRoom) {
                            foundCancel = true;

                            if (room.booked) {
                                room.booked = false;
                                System.out.println("Reservation Cancelled!");
                            } else {
                                System.out.println("Room is Not Booked!");
                            }
                        }
                    }

                    if (!foundCancel) {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You for Using Hotel Reservation System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }

        } while (choice != 4);

        sc.close();
    }
}