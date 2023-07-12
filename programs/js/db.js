const fs = require('fs');
const path = require('path');
const crypto = require('crypto');

class PersistentDatabase {
    constructor(directory) {
        this.directory = directory;
        this.index = {};
        this.cityIndex = {};

        if (!fs.existsSync(directory)) {
            fs.mkdirSync(directory);
        } else {
            const files = fs.readdirSync(directory);
            files.forEach((filename) => {
                const key = filename.replace('.json', '');
                const entry = this.loadEntry(key);
                this.index[key] = true;
                this.addToCityIndex(entry.city, entry);
            });
        }
    }

    get(id) {
        const filename = this.getFilename(id);
        if (fs.existsSync(filename)) {
            return this.loadEntry(id);
        }
        return undefined;
    }

    set(data) {
        const id = this.generateId();
        const filename = this.getFilename(id);
        const entry = { id, ...data };
        fs.writeFileSync(filename, JSON.stringify(entry));
        this.index[id] = true;
        this.addToCityIndex(entry.city, entry);
        return id;
    }

    update(id, data) {
        const filename = this.getFilename(id);
        if (fs.existsSync(filename)) {
          const entry = this.loadEntry(id);
          const updatedEntry = { ...entry, ...data };
          fs.writeFileSync(filename, JSON.stringify(updatedEntry));
          this.removeFromCityIndex(entry.city, id);
          this.addToCityIndex(updatedEntry.city, updatedEntry);
          return true;
        }
        return false;
    }

    remove(id) {
        const filename = this.getFilename(id);
        if (fs.existsSync(filename)) {
            const entry = this.loadEntry(id);
            this.removeFromCityIndex(entry.city, id);
            fs.unlinkSync(filename);
        }
        delete this.index[id];
    }

    getAllIds() {
        return Object.keys(this.index);
    }

    getEntriesByCity(city) {
        if (this.cityIndex[city]) {
            return Object.values(this.cityIndex[city]);
        }
        return [];
    }

    getFilename(id) {
        return path.join(this.directory, `${id}.json`);
    }

    generateId() {
        return crypto.randomBytes(8).toString('hex');
    }

    loadEntry(id) {
        const filename = this.getFilename(id);
        if (fs.existsSync(filename)) {
            const fileData = fs.readFileSync(filename);
            return JSON.parse(fileData);
        }
        return undefined;
    }

    addToCityIndex(city, entry) {
        if (!this.cityIndex[city]) {
            this.cityIndex[city] = {};
        }
        this.cityIndex[city][entry.id] = entry;
    }

    removeFromCityIndex(city, id) {
        if (this.cityIndex[city]) {
            delete this.cityIndex[city][id];
            if (Object.keys(this.cityIndex[city]).length === 0) {
                delete this.cityIndex[city];
            }
        }
    }
}

const dataDirectory = path.join(__dirname, 'data');
const db = new PersistentDatabase(dataDirectory);

const jsonData = [
    { "name": "John", "age": 30, "city": "New York" },
    { "name": "Matthew", "age": 40, "city": "Albuquerque" },
    { "name": "Scarlett", "age": 28, "city": "Tucson" },
    { "name": "Jackson", "age": 57, "city": "Fresno" },
    { "name": "Lily", "age": 46, "city": "Sacramento" },
    { "name": "David", "age": 24, "city": "Long Beach" },
    { "name": "Anthony", "age": 47, "city": "Cleveland" },
    { "name": "Madison", "age": 39, "city": "Wichita" },
    { "name": "Isaac", "age": 31, "city": "Arlington" },
    { "name": "Aria", "age": 38, "city": "New Orleans" },
    { "name": "Miles", "age": 23, "city": "Bakersfield" }
];

/**
 * Please Uncomment the below code while running the code for the first time, 
 * this will add all the entries to the database
 * After first run comment this piece of code
*/

// jsonData.forEach((data) => {
//     db.set(data);
// });

/**
 * Please Uncomment the below code after running the above code, 
 * this is to test upadte and remove and get part of db operation
 * Accordingly change the id set in the below piece of code
*/

// console.log("   ===     GET BY ID   ===     ", db.get('4ef714c83328d291')); //Give any generated id's here to fetch value

// db.remove('4ef714c83328d291');

// console.log("   ===     GET BY ID AFTER DELETING   ===     ", db.get('4ef714c83328d291')); // Output: undefined

// const entriesByCity = db.getEntriesByCity('Cleveland');
// console.log("   ===     GET BY CITY NAME    ===     ", entriesByCity); 

// db.update('9d566e825b68d59c', { age: 31 }); // Update the age of entry with ID '1'

// console.log("   ===     GET BY ID AFTER UPDATING   ===     ", db.get('9d566e825b68d59c'));

// const allIds = db.getAllIds();
// console.log("   ===     GET ALL THE IDS     ===     ",allIds); 