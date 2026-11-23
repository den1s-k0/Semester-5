let orders = [
  {
    id: '1',
    description: 'Поездка по адресу ул. Ленина, 5',
    createdAt: new Date('2026-11-21T14:48:00'),
    author: 'Иванов И.И.',
    pickupAddress: 'р-т Независимости, 120',
    deliveryAddress: 'ул. Ленина, 5',
    serviceType: 'business',
    status: 'in_progress',
    driver: 'Петров П.П.',
    price: 25.50
  },
  {
    id: '2',
    description: 'Поездка по адресу ул. Немига, 12',
    createdAt: new Date('2026-11-21T14:52:00'),
    author: 'Сидорова А.В.',
    pickupAddress: 'ул. Притыцкого, 29',
    deliveryAddress: 'ул. Немига, 12',
    serviceType: 'economy',
    status: 'in_progress',
    driver: 'Козлов Д.С.',
    price: 11.80
  },
  {
    id: '3',
    description: 'Поездка по адресу пр-т Победителей, 84',
    createdAt: new Date('2026-11-21T14:55:00'),
    author: 'Кузнецов М.А.',
    pickupAddress: 'ул. Кальварийская, 17',
    deliveryAddress: 'пр-т Победителей, 84',
    serviceType: 'business',
    status: 'in_progress',
    driver: 'Морозов В.И.',
    price: 19.60
  },
  {
    id: '4',
    description: 'Поездка по адресу ул. Сурганова, 48',
    createdAt: new Date('2026-11-21T14:58:00'),
    author: 'Попова Е.С.',
    pickupAddress: 'ул. Якуба Коласа, 73',
    deliveryAddress: 'ул. Сурганова, 48',
    serviceType: 'economy',
    status: 'new',
    driver: null,
    price: 7.40
  },
  {
    id: '5',
    description: 'Поездка по адресу ул. Мстиславца, 11',
    createdAt: new Date('2026-11-21T15:00:00'),
    author: 'Смирнов О.П.',
    pickupAddress: 'пр-т Независимости, 95',
    deliveryAddress: 'ул. Мстиславца, 11',
    serviceType: 'economy',
    status: 'new',
    driver: null,
    price: 8.90
  },
  {
    id: '6',
    description: 'Поездка по адресу ул. Тимирязева, 65',
    createdAt: new Date('2026-11-21T15:01:00'),
    author: 'Волкова Н.Д.',
    pickupAddress: 'ул. Богдановича, 40',
    deliveryAddress: 'ул. Тимирязева, 65',
    serviceType: 'business',
    status: 'new',
    driver: null,
    price: 16.30
  },
  {
    id: '7',
    description: 'Поездка по адресу ул. Кедышко, 12',
    createdAt: new Date('2026-11-21T15:02:00'),
    author: 'Лебедев К.Н.',
    pickupAddress: 'ул. Кнорина, 30',
    deliveryAddress: 'ул. Кедышко, 12',
    serviceType: 'economy',
    status: 'new',
    driver: null,
    price: 6.70
  },
  {
    id: '8',
    description: 'Поездка по адресу ул. Одоевского, 105',
    createdAt: new Date('2026-11-21T15:03:00'),
    author: 'Соколова И.Р.',
    pickupAddress: 'ул. Неманская, 8',
    deliveryAddress: 'ул. Одоевского, 105',
    serviceType: 'economy',
    status: 'new',
    driver: null,
    price: 13.20
  },
  {
    id: '9',
    description: 'Поездка по адресу ул. Аэродромная, 18',
    createdAt: new Date('2026-11-21T13:30:00'),
    author: 'Никитин А.С.',
    pickupAddress: 'ул. Бобруйская, 6',
    deliveryAddress: 'ул. Аэродромная, 18',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Фёдоров С.А.',
    price: 9.50
  },
  {
    id: '10',
    description: 'Поездка по адресу пр-т Дзержинского, 119',
    createdAt: new Date('2026-11-21T13:45:00'),
    author: 'Егорова Т.В.',
    pickupAddress: 'ул. Есенина, 30',
    deliveryAddress: 'пр-т Дзержинского, 119',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Гусев А.А.',
    price: 10.80
  },
  {
    id: '11',
    description: 'Поездка по адресу ул. Ульяновская, 25',
    createdAt: new Date('2026-11-21T14:00:00'),
    author: 'Павлов В.М.',
    pickupAddress: 'ул. Ленина, 12',
    deliveryAddress: 'ул. Ульяновская, 25',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Орлов Н.В.',
    price: 7.90
  },
  {
    id: '12',
    description: 'Поездка по адресу пр-т Пушкина, 39',
    createdAt: new Date('2026-11-21T14:10:00'),
    author: 'Филиппова Д.К.',
    pickupAddress: 'ул. Максима Богдановича, 21',
    deliveryAddress: 'пр-т Пушкина, 39',
    serviceType: 'business',
    status: 'completed',
    driver: 'Захаров П.П.',
    price: 21.40
  },
  {
    id: '13',
    description: 'Поездка по адресу ул. Бурдейного, 6',
    createdAt: new Date('2026-11-21T14:15:00'),
    author: 'Тарасов Р.И.',
    pickupAddress: 'ул. Голубева, 9',
    deliveryAddress: 'ул. Бурдейного, 6',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Максимов Д.О.',
    price: 8.30
  },
  {
    id: '14',
    description: 'Поездка по адресу ул. Калиновского, 55',
    createdAt: new Date('2026-11-21T14:20:00'),
    author: 'Зайцева О.Л.',
    pickupAddress: 'ул. Лукьяновича, 12',
    deliveryAddress: 'ул. Калиновского, 55',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Борисов И.С.',
    price: 14.10
  },
  {
    id: '15',
    description: 'Поездка по адресу ул. Ротмистрова, 70',
    createdAt: new Date('2026-11-21T14:25:00'),
    author: 'Данилов С.Е.',
    pickupAddress: 'ул. Никифорова, 19',
    deliveryAddress: 'ул. Ротмистрова, 70',
    serviceType: 'economy',
    status: 'completed',
    driver: 'Крылов А.Д.',
    price: 6.20
  },
  {
    id: '16',
    description: 'Поездка по адресу ул. Плеханова, 44',
    createdAt: new Date('2026-11-21T12:40:00'),
    author: 'Комарова Е.А.',
    pickupAddress: 'ул. Будённого, 15',
    deliveryAddress: 'ул. Плеханова, 44',
    serviceType: 'economy',
    status: 'cancelled',
    driver: null,
    price: 5.80
  },
  {
    id: '17',
    description: 'Поездка по адресу ул. Притыцкого, 156',
    createdAt: new Date('2026-11-21T13:10:00'),
    author: 'Мельник Н.П.',
    pickupAddress: 'пр-т Победителей, 120',
    deliveryAddress: 'ул. Притыцкого, 156',
    serviceType: 'business',
    status: 'cancelled',
    driver: null,
    price: 24.70
  },
  {
    id: '18',
    description: 'Поездка по адресу ул. Коржа, 8',
    createdAt: new Date('2026-11-21T14:05:00'),
    author: 'Ковалёв Д.С.',
    pickupAddress: 'ул. Домбровская, 3',
    deliveryAddress: 'ул. Коржа, 8',
    serviceType: 'economy',
    status: 'cancelled',
    driver: null,
    price: 4.90
  },
  {
    id: '19',
    description: 'Поездка по адресу пр-т Машерова, 17',
    createdAt: new Date('2026-11-21T14:35:00'),
    author: 'Григорьева А.М.',
    pickupAddress: 'ул. Красная, 7',
    deliveryAddress: 'пр-т Машерова, 17',
    serviceType: 'economy',
    status: 'cancelled',
    driver: null,
    price: 6.10
  },
  {
    id: '20',
    description: 'Поездка по адресу ул. Жилуновича, 15',
    createdAt: new Date('2026-11-21T14:42:00'),
    author: 'Алексеев В.Г.',
    pickupAddress: 'ул. Ванеева, 22',
    deliveryAddress: 'ул. Жилуновича, 15',
    serviceType: 'economy',
    status: 'cancelled',
    driver: null,
    price: 7.60
  }
];

console.log(orders.length);
console.table(orders);

/* ------------------------------------------------------------
   2. КЛАСС-КОЛЛЕКЦИЯ (MVC-модель)
   Приватные поля: #orders
   Приватные методы: #validateDescription, #validateDate,
                     #validateAuthor, #findIndexById
   ------------------------------------------------------------ */

class OrderCollection {
  #orders;

  constructor(orders = []) {
    this.#orders = Array.isArray(orders) ? [...orders] : [];
  }

  /* ---------- Приватные вспомогательные методы ---------- */

  #validateDescription(desc) {
    return typeof desc === 'string' && desc.length > 0 && desc.length < 200;
  }

  #validateDate(date) {
    return date instanceof Date && !isNaN(date.getTime());
  }

  #validateAuthor(author) {
    return typeof author === 'string' && author.trim().length > 0;
  }

  #findIndexById(id) {
    return this.#orders.findIndex(o => o.id === id);
  }

  /* ---------- Публичные методы (API) ---------- */

  // Валидация объекта (по ТЗ — публичная)
  validateObj(obj) {
    if (!obj || typeof obj !== 'object') return false;
    return (
      typeof obj.id === 'string' && obj.id.trim() !== '' &&
      this.#validateDescription(obj.description) &&
      this.#validateDate(obj.createdAt) &&
      this.#validateAuthor(obj.author) &&
      (obj.photoLink === undefined || typeof obj.photoLink === 'string')
    );
  }

  // Получить массив с пагинацией, сортировкой по createdAt и фильтром
  getObjs(skip = 0, top = 10, filterConfig = {}) {
    let result = [...this.#orders];

    // Фильтрация
    if (filterConfig && Object.keys(filterConfig).length > 0) {
      result = result.filter(order => {
        return Object.entries(filterConfig).every(([key, value]) => {
          if (value === undefined || value === null || value === '') return true;
          if (key === 'createdAt' && value instanceof Date) {
            return order.createdAt.getTime() === value.getTime();
          }
          return order[key] === value;
        });
      });
    }

    // Сортировка по createdAt (по возрастанию)
    result.sort((a, b) => a.createdAt - b.createdAt);

    // Пагинация
    return result.slice(skip, skip + top);
  }

  getObj(id) {
    const found = this.#orders.find(o => o.id === id);
    return found || null;
  }

  addObj(obj) {
    if (!this.validateObj(obj)) return false;
    if (this.#findIndexById(obj.id) !== -1) return false;
    this.#orders.push({ ...obj });
    return true;
  }

  editObj(id, updates) {
    const index = this.#findIndexById(id);
    if (index === -1) return false;

    // Запрещено менять id, author, createdAt
    if ('id' in updates || 'author' in updates || 'createdAt' in updates) return false;

    const updated = { ...this.#orders[index], ...updates };
    if (!this.validateObj(updated)) return false;

    this.#orders[index] = updated;
    return true;
  }

  removeObj(id) {
    const index = this.#findIndexById(id);
    if (index === -1) return false;
    this.#orders.splice(index, 1);
    return true;
  }

  addAll(orders) {
    if (!Array.isArray(orders)) return false;
    for (const o of orders) this.addObj(o);
    return this.#orders;
  }

  clear() {
    this.#orders = [];
  }

  get size() {
    return this.#orders.length;
  }
}

/* ------------------------------------------------------------
   3. СВЯЗКА С ИНТЕРФЕЙСОМ (View)
   ------------------------------------------------------------ */

// Создаём глобальную коллекцию на основе данных
const collection = new OrderCollection(orders);

// Функция рендера таблицы заказов
function renderOrders(orders) {
  const tbody = document.getElementById('orders-tbody');
  if (!tbody) return;

  tbody.innerHTML = '';

  if (orders.length === 0) {
    tbody.innerHTML = '<tr><td colspan="6" style="text-align:center;">Заказы не найдены</td></tr>';
    return;
  }

  const statusLabels = {
    'new': 'Новый',
    'accepted': 'Принят',
    'in_progress': 'В пути',
    'completed': 'Завершён',
    'cancelled': 'Отменён'
  };

  orders.forEach(o => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${o.id}</td>
      <td>${o.pickupAddress || '—'}</td>
      <td>${o.deliveryAddress || '—'}</td>
      <td>${o.serviceType === 'business' ? 'Бизнес' : 'Эконом'}</td>
      <td>${statusLabels[o.status] || o.status}</td>
      <td><a class="btn btn--small" href="#screen-order-view" data-id="${o.id}">Просмотр</a></td>
    `;
    tbody.appendChild(tr);
  });
}

// Первичный рендер при загрузке страницы
document.addEventListener('DOMContentLoaded', () => {
  // Рендер таблицы
  renderOrders(collection.getObjs(0, 100));

  // Обработчик просмотра заказа
  document.getElementById('orders-tbody').addEventListener('click', (e) => {
    const link = e.target.closest('a[data-id]');
    if (!link) return;
    const id = link.dataset.id;
    const order = collection.getObj(id);
    if (!order) return;
    // Заполняем карточку просмотра
    document.getElementById('view-id').textContent = order.id;
    document.getElementById('view-pickup').textContent = order.pickupAddress || '—';
    document.getElementById('view-delivery').textContent = order.deliveryAddress || '—';
    document.getElementById('view-class').textContent = order.serviceType === 'business' ? 'Бизнес' : 'Эконом';
    document.getElementById('view-status').textContent = order.status;
    document.getElementById('view-driver').textContent = order.driver || '—';
    document.getElementById('view-price').textContent = order.price ? order.price + ' BYN' : '—';
    document.getElementById('view-date').textContent = order.createdAt.toLocaleDateString('ru-RU');
  });

  // Фильтр по статусу
  document.getElementById('orders-filter-status').addEventListener('change', (e) => {
    const status = e.target.value;
    const filter = status ? { status } : {};
    renderOrders(collection.getObjs(0, 100, filter));
  });

  // Поиск по адресу (фильтрация по подстроке)
  document.getElementById('orders-search').addEventListener('input', (e) => {
    const query = e.target.value.toLowerCase();
    const all = collection.getObjs(0, 100);
    const filtered = all.filter(o =>
      (o.pickupAddress || '').toLowerCase().includes(query) ||
      (o.deliveryAddress || '').toLowerCase().includes(query)
    );
    renderOrders(filtered);
  });

  // Сортировка по дате (по убыванию — свежие сверху)
  document.getElementById('orders-sort-date').addEventListener('click', () => {
    const all = collection.getObjs(0, 100);
    all.sort((a, b) => b.createdAt - a.createdAt);
    renderOrders(all);
  });

  // Сортировка по номеру (по возрастанию)
  document.getElementById('orders-sort-id').addEventListener('click', () => {
    const all = collection.getObjs(0, 100);
    all.sort((a, b) => parseInt(a.id) - parseInt(b.id));
    renderOrders(all);
  });

  // Форма редактирования — сохранение
  const editForm = document.getElementById('edit-order-form');
  if (editForm) {
    editForm.addEventListener('submit', (e) => {
      e.preventDefault();
      const id = editForm.dataset.orderId;
      if (!id) return alert('Не выбран заказ для редактирования');
      const updates = {
        pickupAddress: document.getElementById('edit-pickup').value,
        deliveryAddress: document.getElementById('edit-delivery').value,
        status: document.getElementById('edit-status').value
      };
      const ok = collection.editObj(id, updates);
      alert(ok ? 'Заказ сохранён' : 'Ошибка сохранения');
      if (ok) renderOrders(collection.getObjs(0, 100));
    });
  }
});

/* ------------------------------------------------------------
   4. ПРОВЕРКА МЕТОДОВ В КОНСОЛИ (для отчёта)
   Откройте DevTools → Console и по очереди вставьте.
   ------------------------------------------------------------ */

console.log('=== ЗАГРУЗКА ===');
console.log('Всего заказов:', collection.size);
console.table(collection.getObjs(0, 5));

// Пагинация
console.log('Первые 5:', collection.getObjs(0, 5));
console.log('С 6 по 10:', collection.getObjs(5, 5));

// Фильтрация
console.log('Только business:', collection.getObjs(0, 100, { serviceType: 'business' }));
console.log('Только completed:', collection.getObjs(0, 100, { status: 'completed' }));

// Получение одного
console.log('Заказ 1:', collection.getObj('1'));
console.log('Заказ 999 (нет):', collection.getObj('999'));

// Валидация
console.log('Валидный:', collection.validateObj({ id: '200', description: 'Тест', createdAt: new Date(), author: 'Тест Т.Т.' }));
console.log('Нет id:', collection.validateObj({ description: 'Тест', createdAt: new Date(), author: 'Тест Т.Т.' }));
console.log('Пустой author:', collection.validateObj({ id: '201', description: 'Тест', createdAt: new Date(), author: '' }));

// Добавление
console.log('addObj valid:', collection.addObj({ id: '300', description: 'Новый заказ', createdAt: new Date(), author: 'Новиков Н.Н.', pickupAddress: 'A', deliveryAddress: 'B', serviceType: 'econom', status: 'new', driver: '', price: 0 }));
console.log('addObj дубликат:', collection.addObj({ id: '1', description: 'Дубль', createdAt: new Date(), author: 'Дубль Д.Д.' }));

// Редактирование
console.log('editObj status:', collection.editObj('300', { status: 'accepted' }));
console.log('editObj author (запрещено):', collection.editObj('300', { author: 'Другой' }));
console.log('editObj невалидный:', collection.editObj('300', { description: '' }));

// Удаление
console.log('removeObj 300:', collection.removeObj('300'));
console.log('removeObj 999:', collection.removeObj('999'));

// addAll / clear
collection.addAll([
  { id: '400', description: 'Опт 1', createdAt: new Date(), author: 'А', pickupAddress: 'X', deliveryAddress: 'Y', serviceType: 'econom', status: 'new', driver: '', price: 0 },
  { id: '401', description: 'Опт 2', createdAt: new Date(), author: 'Б', pickupAddress: 'X', deliveryAddress: 'Y', serviceType: 'econom', status: 'new', driver: '', price: 0 }
]);
console.log('После addAll размер:', collection.size);

