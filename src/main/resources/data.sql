INSERT INTO menu(Id_menu, Name, Price) VALUES
(1, 'Grilled Atlantic Salmon Steak', 98000.00),
(2, 'Spaghetti Garlic Shrimp Scampi', 77000.00),
(3, 'Linguine Aglio Olio', 68000.00),
(4, 'Bean Nachos', 76000.00),
(5, 'Mexican Sandwich', 63000.00),
(6, 'Perogies', 90000.00);


INSERT INTO order_food(Id_Order, Id_Table, Number_Table, Id_menu, Name_Menu, Price_Menu, Quantity_Menu) VALUES
(1, 1, 1, 1,  'Grilled Atlantic Salmon Steak', 98000.00, 1),
(2, 2, 2, 2,  'Spaghetti Garlic Shrimp Scampi', 77000.00, 2);

INSERT INTO invoice(Id_Invoice, Id_Table, Number_Table, Id_Order, Id_Menu, Name_Menu, Price_Menu, Quantity_Menu, Sub_Total, Tax, Service_Charge, Discount, Total_Amount) VALUES
(1, 1, 1, 1, 1, 'Grilled Atlantic Salmon Steak', 98000.00, 1, 98000.00, 10000.00, 14500.00, 10000.00, 150000.00);

INSERT INTO table_order(Id_Table, Number_Table) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

INSERT  INTO transaction_invoice(Id_Transaction, Id_Table, Total_Amount, Cash, Change) VALUES
(1, 1,  150000.00, 200000.00, 50000.00);