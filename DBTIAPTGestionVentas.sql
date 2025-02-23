-- Crear la base de datos
CREATE DATABASE DBTIAPTGestionVentas;
\c DB_PRUEBA1;

-- Tabla de Usuarios
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password TEXT NOT NULL,
    home_address TEXT,
    DNI VARCHAR(10) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- Tabla de Tiendas
CREATE TABLE shops (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    contact VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    opening_time TIME NOT NULL,
    closing_time TIME NOT NULL
);

-- Tabla de Productos
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    SKU VARCHAR(50) UNIQUE NOT NULL,
    category VARCHAR(100) NOT NULL,
    description TEXT,
    state INTEGER DEFAULT 1,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- Tabla de Inventario 
CREATE TABLE products_shops_inventory (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    shop_id INT NOT NULL,
    stock INT NOT NULL CHECK (stock > 0),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    FOREIGN KEY (shop_id) REFERENCES shops(id) ON DELETE CASCADE
);

-- Tabla de Ventas
CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    shop_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(50) DEFAULT 'cash',
    purchase_date TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (shop_id) REFERENCES shops(id) ON DELETE CASCADE
);

-- Tabla de Detalles de Venta
CREATE TABLE sale_details (
    id SERIAL PRIMARY KEY,
    sale_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

INSERT INTO users (first_name, phone, email, password, home_address, DNI)
VALUES 
('David Terreros', '123456789', 'dterrero@gmail.com', '1234', 'Av. Siempre Viva 123', '987654321'),
('Ana Gómez', '987654321', 'ana@example.com', 'pass123', 'Calle 45', '123456789'),
('Carlos López', '555666777', 'carlos@example.com', 'pass123', 'Av. Central 89', '456123789'),
('María Rodríguez', '111222333', 'maria@example.com', 'pass123', 'Zona Norte 50', '321654987'),
('Pedro Sánchez', '444555666', 'pedro@example.com', 'pass123', 'Calle Sur 77', '654987321'),
('Luis Torres', '777888999', 'luis@example.com', 'pass123', 'Av. Este 12', '789456123'),
('Andrea Castillo', '112233445', 'andrea@example.com', 'pass123', 'Av. Oeste 34', '963258741'),
('Sofía Fernández', '556677889', 'sofia@example.com', 'pass123', 'Centro 11', '741852963'),
('Fernando Ramírez', '999888777', 'fernando@example.com', 'pass123', 'Calle Uno', '852963741'),
('Javier Muñoz', '223344556', 'javier@example.com', 'pass123', 'Zona Centro 22', '753159852');

INSERT INTO shops (name, address, contact, phone, opening_time, closing_time)
VALUES 
('Tienda Centro', 'Av. Principal 123', 'Carlos Ramos', '123123123', '08:00', '20:00'),
('Tienda Norte', 'Calle Norte 456', 'Ana López', '456456456', '09:00', '21:00'),
('Tienda Sur', 'Av. Sur 789', 'Juan Pérez', '789789789', '10:00', '22:00'),
('Tienda Este', 'Calle Este 101', 'Pedro Sánchez', '101101101', '07:00', '19:00'),
('Tienda Oeste', 'Av. Oeste 202', 'María Gómez', '202202202', '09:30', '21:30');

INSERT INTO products (name, price, SKU, category, description)
VALUES 
('Laptop', 1200.00, 'LAP-001', 'Tecnología', 'Laptop potente con 16GB RAM'),
('Smartphone', 800.00, 'SMT-002', 'Electrónica', 'Smartphone con cámara de 48MP'),
('Teclado Mecánico', 100.00, 'KB-003', 'Accesorios', 'Teclado mecánico RGB'),
('Monitor 27"', 300.00, 'MON-004', 'Periféricos', 'Monitor Full HD 144Hz'),
('Audífonos Bluetooth', 50.00, 'AUD-005', 'Audio', 'Audífonos inalámbricos de alta calidad');

INSERT INTO products_shops_inventory (product_id, shop_id, stock)
VALUES 
(1, 1, 10), (1, 2, 15), (2, 3, 20), (3, 4, 5), (4, 5, 8),
(2, 1, 12), (3, 2, 18), (4, 3, 25), (5, 4, 30), (1, 5, 7);

INSERT INTO sales (user_id, shop_id, total, payment_method)
VALUES 
(1, 1, 1500.00, 'card'),
(2, 2, 500.00, 'cash'),
(3, 3, 120.00, 'card'),
(4, 4, 300.00, 'card'),
(5, 5, 900.00, 'cash');

INSERT INTO sale_details (sale_id, product_id, quantity)
VALUES 
(1, 1, 2), (1, 2, 1), (2, 3, 3), (3, 4, 1), (4, 5, 2),
(5, 2, 1), (2, 1, 1), (3, 5, 3), (4, 4, 2), (5, 3, 2);

