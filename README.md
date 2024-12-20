# Selective Waste Sorting Management System

## Overview
This project implements a waste management system that encourages selective sorting. The system aims to reward households and businesses for properly sorting their waste through a loyalty points mechanism. Points can be redeemed for discounts or gift cards at partner businesses.

## Features
- **Smart Bins**: Controlled-access bins equipped with sensors to measure the type and quantity of deposited waste.
- **Loyalty Points System**: Rewards users for depositing the correct type of waste; penalizes for incorrect sorting.
- **Partner Integration**: Collaboration with businesses to offer rewards and discounts.

## Technologies Used
- **Java**: Core functionality, including simulation of features and GUI.
- **OpenJDK and OpenJFX (Version 18)**: Build and test the graphical user interface.

## System Components
1. **Households**: Users who deposit waste in smart bins and earn points.
2. **Smart Bins**:
   - Types: Green (glass), Yellow (packaging/plastics), Blue (paper), and Classic (unsorted).
   - Features:
     - Detect type and quantity of waste.
     - Penalize incorrect sorting.
     - Notify collection centers when full.
3. **Collection Centers**: Manage bins, collect waste, and monitor sorting performance.
4. **Partner Businesses**: Collaborate to provide discounts and incentives for users.

## Installation and Setup
### Prerequisites
- **Java Development Kit (JDK 18)**: Ensure OpenJDK 18 and OpenJFX 18 are installed.

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/smart-waste-management.git
   ```
2. Navigate to the project directory and ensure data files are placed appropriately.
3. Compile and run the Java program:
   ```bash
   javac -d bin src/*.java
   java -cp bin MainTest
   ```
4. For GUI:
   ```bash
   java -jar smart-waste-management.jar
   ```

## Example Usage
- **Loyalty Points**:
  - Deposit 10kg of plastic waste → Earn 100 points.
  - Incorrectly deposit glass in a plastic bin → Lose 50 points.
- **Redeem Points**:
  - 500 points = 5% discount on grocery items at partner stores.

## Contribution
We welcome contributions to improve the project:
1. Fork the repository.
2. Create a new branch for your feature.
3. Submit a pull request with a detailed description.

## License
This project is licensed under the MIT License.

## Author
ANTOGNELLI Pauline
