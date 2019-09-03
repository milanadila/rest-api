INSERT INTO menu(Id_menu, Name, Price, Stock, Category) VALUES
(1, 'Grilled Atlantic Salmon Steak', 98000, 5, 'Italian Food'),
(2, 'Spaghetti Garlic Shrimp Scampi', 77000, 6, 'Italian Food'),
(3, 'Linguine Aglio Olio', 68000, 4, 'Italian Food'),
(4, 'Bean Nachos', 76000, 5, 'Mexican Food'),
(5, 'Mexican Sandwich', 63000, 5, 'Mexican Food'),
(6, 'Perogies', 90000, 5, 'Mexican Food');


INSERT INTO order_food(Id_Order, Id_Table, Number_Table, Id_menu, Name_Menu, Price_Menu, Quantity_Menu) VALUES
(1, 1, 1, 1,  'Grilled Atlantic Salmon Steak', 98000, 1),
(2, 2, 2, 2,  'Spaghetti Garlic Shrimp Scampi', 77000, 2);

INSERT INTO invoice(Id_Invoice, Id_Table, Number_Table, Id_Order, Id_Menu, Name_Menu, Price_Menu, Quantity_Menu, Sub_Total, Tax, Service_Charge, Total_Amount, Discount) VALUES
(1, 1, 1, 1, 1, 'Grilled Atlantic Salmon Steak', 98000, 1, 98000, 0.10, 0.15, 150000, 10000);

INSERT INTO table_order(Id_Table, Number_Table) VALUES
(1, 1),
(2, 2);

