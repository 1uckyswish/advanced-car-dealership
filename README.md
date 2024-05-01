# Advanced Java Car Dealership

Advanced Java Car Dealership is a user-friendly console-based application tailored for sales professionals and managers in a car dealership environment. It's designed to streamline the car purchasing experience by providing intuitive functionalities for managing inventory and assisting customers. This project is a comprehensive dealership application that empowers users to efficiently perform various operations, enhancing the overall workflow. The application offers essential features such as finding vehicles within specified criteria, listing all vehicles, adding or removing vehicles, and quitting the application. The vehicles in the inventory will be stored in a pipe-delimited file, requiring updates for any modifications to maintain consistency.

### Pillars of OOP in JavaCar Dealership:

- **Encapsulation**:
  - Data and methods are encapsulated within classes for vehicle and inventory management.
  - Shields internal details, promoting modularity and ease of maintenance.
  - Ensures data integrity and prevents unauthorized access or modification.

- **Polymorphism**:
  - Treats various vehicle types uniformly through inheritance and method overriding.
  - Enables seamless interaction with diverse vehicle models and functionalities.
  - Facilitates code reuse and enhances user experience.

- **Abstraction**:
  - Hides complex implementation details behind simplified interfaces.
  - Users interact through intuitive commands without needing to understand underlying complexities.
  - Fosters clarity, reduces cognitive load, and supports future modifications.

- **Inheritance**:
  - Establishes relationships between vehicle types using superclass and subclasses.
  - Enables sharing of attributes and behaviors while allowing specialization when needed.

## Main Class (Home)

This is the heart of our Java Car Dealership project. The Main class manages all store functionalities. Check out the Maven Java folder structure on the left to see how the project is organized.

<img width="1440" alt="Screenshot 2024-04-27 at 8 44 10 PM" src="https://github.com/1uckyswish/advanced-car-dealership/assets/107442415/4d9eef4f-01a4-4420-8278-36f292d5a995">

## Start of Program

This is the main screen of the Java Car Dealership interface, offering users a variety of options to explore.

<img width="1440" alt="Screenshot 2024-04-27 at 8 49 52 PM" src="https://github.com/1uckyswish/advanced-car-dealership/assets/107442415/ba7a2fb1-194c-4cd0-a509-e344f95ac338">

## Option 1: Filter Vehicles by Price:

Filter Vehicles by Price by checking the user's minimum and maximum values and displaying vehicles within that price range.

![Screenshot 2024-04-24 at 11 06 22 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/6655ec50-7ecd-48be-94eb-9085f9ee0433)

## Option 2: Filter Vehicles by Make or Model: 

Filter Vehicles by Make or Model allows users to search for vehicles based on specific make or model criteria, providing a tailored browsing experience.

![Screenshot 2024-04-24 at 11 15 08 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/b448d9f4-be9a-4f72-9445-63ebbd2a4b0c)

## Option 3: Filter Vehicles by Manufactured year:

Filter Vehicles by Manufactured Year enables users to narrow down their search by specifying the manufacturing year of the vehicles, facilitating targeted browsing based on desired age ranges.

![Screenshot 2024-04-24 at 11 18 06 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/9d573659-d398-4d24-a089-71009df385c3)

## Option 4: Filter Vehicles by Color:

Filter Vehicles by Color enables users to refine their search by selecting vehicles based on their exterior color, ensuring personalized browsing experiences tailored to individual preferences.

![Screenshot 2024-04-24 at 11 19 49 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/109d44ea-6552-4e5d-8714-90009328ae17)

## Option 5: Filter Vehicles by Mileage:

Filter Vehicles by Mileage allows users to refine their search based on mileage criteria, ensuring they find vehicles that meet their specific distance requirements and preferences.

![Screenshot 2024-04-24 at 11 21 43 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/5f525be0-701d-4735-b4ae-e64551c41d15)

## Option 6: Filter Vehicles by Vehicle Type:

Filter Vehicles by Vehicle Type enables users to narrow down their search by specifying the type of vehicle they are interested in, such as car, truck, SUV, or van, providing a more targeted browsing experience tailored to their needs.

![Screenshot 2024-04-24 at 11 23 06 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/5712175f-8e03-48cc-90fa-1b00921aef24)

## Option 7: Return all Vehicles In Iventory:

Return All Vehicles in Inventory provides users with a comprehensive list of all vehicles currently available in the dealership's inventory, facilitating easy access to view all available options at once.

![Screenshot 2024-04-24 at 11 35 42 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/ad9ee96f-190e-4c07-8bb8-8ab9bcedf538)

## Option 8: Add A New Vehicle To Iventory:

Add a New Vehicle to Inventory allows users to seamlessly add a new vehicle to the dealership's inventory, ensuring that the system stays up-to-date with the latest available vehicles for potential customers to browse and purchase.

![Screenshot 2024-04-24 at 11 39 12 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/074ead8d-1910-4900-9956-bdd25426f4b0)

## Option 9: Remove A Vehicle From The Iventory:

Remove a Vehicle from the Inventory enables users to efficiently remove a vehicle from the dealership's inventory, ensuring that outdated or sold vehicles are accurately reflected in the system, maintaining inventory accuracy and facilitating smooth operations.

![Screenshot 2024-04-24 at 11 41 02 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/c6832c28-8055-4109-a5a4-42ebaeb91271)

## Error Handling Section

### Main Class (Home) Error handle

The main screen of the Java Car Dealership interface presents users with various options to choose from. It includes error handling to manage instances where users input an option that is not one of the displayed choices. If the user selects the wrong option, a message is displayed, and the menu is presented again for the user to make a correct selection.

![Screenshot 2024-04-24 at 11 43 38 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/b388f9d5-71b0-42bf-9a88-2d0ed78ba715)


### Error Handling for Adding a New Car Using Scanner with Incorrect Data Type from the Given Prompt

Verify the data type entered by the user using the scanner for each input. If the user enters an incompatible data type, such as entering a double when a string is required for the information, display a message indicating that the user input is incorrect.

![Screenshot 2024-04-24 at 11 49 27 AM](https://github.com/1uckyswish/car-dealership/assets/107442415/cfd8409e-2629-46f8-8f3c-7daa78e3eff3)


## Interesting Section of code
 In this section of the code, users have the option to add addons to the vehicle they are purchasing. Just like in a real dealership, when you buy a car, you typically only add one addon of each type. For example, you wouldn't add two GPS systems or two backup cameras to your vehicle, right? To emulate this behavior, I've implemented a check to ensure that users can only add each addon once. If a user attempts to add an addon that has already been selected, they will be notified that the addon cannot be added again. This ensures that users can only add each addon once. Once the user has selected all the addons they want, the total cost of the addons is applied to the total price of the car

<img width="1440" alt="Screenshot 2024-04-27 at 8 44 47 PM" src="https://github.com/1uckyswish/advanced-car-dealership/assets/107442415/9cffbb38-fa8b-4d48-9269-1364c4b0a6fd">



















