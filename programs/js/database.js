const fs = require('fs');

class PersistentDatabase {
  constructor(filename) {
    this.filename = filename;
    this.data = {};
    this.index = {};

    if (fs.existsSync(filename)) {
      const fileData = fs.readFileSync(filename);
      if (fileData) {
        const parsedData = JSON.parse(fileData);
        this.data = parsedData.data || {};
        this.index = parsedData.index || {};
      }
    }
  }

  get(key) {
    return this.data[key];
  }

  set(key, value) {
    this.data[key] = value;
    if (!this.index[key]) {
      this.index[key] = true;
    }
    this.persistData();
  }

  remove(key) {
    delete this.data[key];
    delete this.index[key];
    this.persistData();
  }

  getById(id) {
    const key = Object.keys(this.index).find((k) => this.index[k] && this.data[k].id === id);
    return this.data[key];
  }

  persistData() {
    const dataToPersist = {
      data: this.data,
      index: this.index,
    };
    const dataString = JSON.stringify(dataToPersist);
    fs.writeFileSync(this.filename, dataString);
  }
}

// Usage example
const db = new PersistentDatabase('database.json');

db.set('1', { id: 1, name: 'John', age: 30 });
db.set('2', { id: 2, name: 'Jane', age: 25 });

console.log(db.getById(1));
console.log(db.getById(2));

db.remove('2');

console.log(db.getById(2));
