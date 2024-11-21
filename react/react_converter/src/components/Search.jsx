function Search({search, changeSearchValue}) {
  return (
    <>
      <input type="text" value={search} placeholder="검색어를 입력하세요" 
            onChange={changeSearchValue} />
    </>
  )
}

export default Search;