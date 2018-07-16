export const SESSION_STORAGE = 1;
export const LOCAL_STORAGE = 2;

function getStorage(type = 1) {
  return type === SESSION_STORAGE ? sessionStorage : localStorage;
}

export default {
  get(key, type = 1) {
    let data = getStorage(type).getItem(key);
    if (!data) {
      return null;
    }
    data = JSON.parse(data);
    if (data.time && data.time < Date.now()) {
      return null;
    }
    return data.value;
  },
  set(
    key,
    value,
    options = {
      type: 1,
      time: -1
    }
  ) {
    let data = { value };

    if (options.time >= 0) {
      Object.assign(data, {
        time: options.time + Date.now()
      });
    }
    getStorage(options.type).setItem(key, JSON.stringify(data));
  },
  remove(key, type = 1) {
    getStorage(type).removeItem(key);
  },
  clear(type) {
    getStorage(type).clear();
  }
};
