// show the project with label

document.addEventListener('DOMContentLoaded', function() {
    const filterButtons = document.querySelectorAll('.filter-btn');
    const portfolioGrid = document.querySelector('.portfolio-grid');
    const portfolioItems = document.querySelectorAll('.portfolio-item');

    filterButtons.forEach(button => {
        button.addEventListener('click', function() {
            const filter = this.getAttribute('data-filter');

            // 激活当前按钮
            filterButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');

            // 显示/隐藏项目
            portfolioItems.forEach(item => {
                if (filter === 'all' || item.getAttribute('data-category') === filter) {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
            });

            // 触发布局重排
            portfolioGrid.style.display = 'none'; // 暂时隐藏网格
            setTimeout(() => {
                portfolioGrid.style.display = 'grid'; // 恢复网格布局
            }, 0);
        });
    });
});
