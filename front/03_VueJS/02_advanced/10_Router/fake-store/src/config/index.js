export default {
  title: 'Fake Store', // 메인타이틀
  subtitle: 'Vue3 연습사이트', // 서브타이틀
  menus: [
    // 메인메뉴구성정보
    {
      title: '가전',
      url: '/electronics',
      icon: 'fa-solid fa-tv',
      backgroundImage: '',
    },
    { title: '주얼리', url: '/jewelery', icon: 'fa-solid fa-gem' },
    { title: '남성의류', url: '/mensclothing', icon: 'fa-solid fa-user-tie' },
    {
      title: '여성의류',
      url: '/womensclothing',
      icon: 'fa-solid fa-person-dress',
    },
  ],
};
