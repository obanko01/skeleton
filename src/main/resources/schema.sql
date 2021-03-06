DROP TABLE IF EXISTS receipts;
CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  uploaded TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),
  receipt_type INT UNSIGNED,

  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tags;
CREATE TABLE tags (
  id INT UNSIGNED AUTO_INCREMENT,
  born TIME DEFAULT CURRENT_TIME(),
  receipt_id INT UNSIGNED,
  tag_name VARCHAR(255),
  UNIQUE(receipt_id, tag_name),

  PRIMARY KEY (receipt_id, tag_name),
  FOREIGN KEY (receipt_id) REFERENCES receipts(id)

);

-- SELECT * FROM tags;